package com.safelinevr.safeline_api.service;

import com.safelinevr.safeline_api.dto.CaseStudyDto;
import com.safelinevr.safeline_api.entity.CaseStudy;
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
}