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

    public List<SolutionCategoryDto> findAllSolutionsGroupedByCategory() {
        List<Solution> solutions = solutionRepository.findAll();
        Map<String, List<Solution>> groupedByCategory = solutions.stream()
                .collect(Collectors.groupingBy(Solution::getCategoryTitle));

        return groupedByCategory.entrySet().stream()
                .map(entry -> {
                    String categoryTitle = entry.getKey();
                    List<SolutionItemDto> itemDtos = entry.getValue().stream()
                            .map(solution -> new SolutionItemDto(
                                    solution.getLink(),
                                    solution.getName(),
                                    solution.getTagline(),
                                    solution.getImage()
                            ))
                            .collect(Collectors.toList());
                    String description = getDescriptionForCategory(categoryTitle);
                    return new SolutionCategoryDto(categoryTitle, description, itemDtos);
                })
                .collect(Collectors.toList());
    }

    public SolutionDetailDto findSolutionByLink(String link) {
        Solution solution = solutionRepository.findByLink(link)
                .orElseThrow(() -> new ResourceNotFoundException("Solution not found with link: " + link));
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
}