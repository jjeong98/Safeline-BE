package com.safelinevr.safeline_api.service;

import com.safelinevr.safeline_api.dto.SolutionCategoryDto;
import com.safelinevr.safeline_api.dto.SolutionDetailDto;
import com.safelinevr.safeline_api.dto.SolutionItemDto;
import com.safelinevr.safeline_api.entity.Solution;
import com.safelinevr.safeline_api.exception.ResourceNotFoundException;
import com.safelinevr.safeline_api.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;

    // 기존 findAll() 메소드는 그대로 두거나 삭제해도 됩니다.
    // public List<Solution> findAll() {
    //     return solutionRepository.findAll();
    // }

    public List<SolutionCategoryDto> findAllSolutionsGroupedByCategory() {
        // 1. DB에서 모든 Solution을 가져옵니다.
        List<Solution> solutions = solutionRepository.findAll();

        // 2. 'categoryTitle'을 기준으로 Solution들을 그룹화합니다.
        Map<String, List<Solution>> groupedByCategory = solutions.stream()
                .collect(Collectors.groupingBy(Solution::getCategoryTitle));

        // 3. 그룹화된 데이터를 DTO로 변환합니다.
        return groupedByCategory.entrySet().stream()
                .map(entry -> {
                    String categoryTitle = entry.getKey();
                    List<Solution> solutionItems = entry.getValue();

                    // Solution 리스트를 SolutionItemDto 리스트로 변환
                    List<SolutionItemDto> itemDtos = solutionItems.stream()
                            .map(solution -> new SolutionItemDto(
                                    solution.getLink(), // PRD의 id는 상세페이지 링크용 값이므로 link 필드 사용
                                    solution.getName(),
                                    solution.getTagline(),
                                    solution.getImage()
                            ))
                            .collect(Collectors.toList());

                    // categoryTitle에 따라 description을 하드코딩 (향후 DB에서 관리 가능)
                    String description = getDescriptionForCategory(categoryTitle);

                    return new SolutionCategoryDto(categoryTitle, description, itemDtos);
                })
                .collect(Collectors.toList());
    }

    // 카테고리별 설명을 반환하는 헬퍼 메소드
    private String getDescriptionForCategory(String categoryTitle) {
        switch (categoryTitle) {
            case "하드웨어 솔루션":
                return "산업 현장의 몰입감을 극대화하는 혁신적인 XR 체험 장비";
            case "소프트웨어 & 플랫폼":
                return "완벽한 VR 교육을 위한 강력하고 유연한 통합 운영 시스템";
            case "콘텐츠 패키지":
                return "국내 최다, 산업별/유형별 맞춤형 VR 안전 교육 콘텐츠";
            default:
                return "";
        }
    }

    public SolutionDetailDto findSolutionByLink(String link) {
        // 1. Repository에서 link(slug)로 Solution을 찾습니다.
        Solution solution = solutionRepository.findByLink(link)
                .orElseThrow(() -> new ResourceNotFoundException("Solution not found with link: " + link));

        // 2. 찾은 Entity를 DTO로 변환하여 반환합니다.
        return convertToDetailDto(solution);
    }

    private SolutionDetailDto convertToDetailDto(Solution solution) {
        return SolutionDetailDto.builder()
                .id(solution.getId())
                .categoryTitle(solution.getCategoryTitle())
                .name(solution.getName())
                .tagline(solution.getTagline())
                .image(solution.getImage())
                .build();
    }
}