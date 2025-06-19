package com.safelinevr.safeline_api.service;

import com.safelinevr.safeline_api.dto.CaseStudyDetailDto;
import com.safelinevr.safeline_api.dto.CaseStudyDto;
import com.safelinevr.safeline_api.entity.CaseStudy;
import com.safelinevr.safeline_api.exception.ResourceNotFoundException;
import com.safelinevr.safeline_api.repository.CaseStudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaseStudyService {

    private final CaseStudyRepository caseStudyRepository;

    public List<CaseStudyDto> findAllCaseStudies() {
        List<CaseStudy> caseStudies = caseStudyRepository.findAll();
        System.out.println("###Debug: " + caseStudies.size() + "고객 사례, Dto 변환");

        return caseStudies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CaseStudyDto convertToDto(CaseStudy caseStudy) {
        return new CaseStudyDto(
                caseStudy.getSlug(),
                caseStudy.getClientName(),
                caseStudy.getClientLogo(),
                caseStudy.getImpactHeadline()
        );
    }

    public CaseStudyDetailDto findCaseStudyBySlug(String slug) {
        CaseStudy caseStudy = caseStudyRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("CaseStudy not found with slug: " + slug));

        return convertToDetailDto(caseStudy);
    }

    private CaseStudyDetailDto convertToDetailDto(CaseStudy caseStudy) {
        return CaseStudyDetailDto.builder()
                .id(caseStudy.getId())
                .clientName(caseStudy.getClientName())
                .clientLogo(caseStudy.getClientLogo())
                .impactHeadline(caseStudy.getImpactHeadline())
                .build();
    }
}