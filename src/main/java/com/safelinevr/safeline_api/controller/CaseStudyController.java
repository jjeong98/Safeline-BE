package com.safelinevr.safeline_api.controller;

import com.safelinevr.safeline_api.dto.CaseStudyDetailDto;
import com.safelinevr.safeline_api.dto.CaseStudyDto;
import com.safelinevr.safeline_api.service.CaseStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor // 생성자 주입을 위한 어노테이션 추가
public class CaseStudyController {

    private final CaseStudyService caseStudyService; // Service 주입

    @GetMapping
    public ResponseEntity<Map<String, List<CaseStudyDto>>> getAllCaseStudies() {
        // Service를 통해 DTO 리스트를 가져옴
        List<CaseStudyDto> caseStudies = caseStudyService.findAllCaseStudies();

        Map<String, List<CaseStudyDto>> response = new HashMap<>();
        response.put("caseStudies", caseStudies);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<CaseStudyDetailDto> getCaseStudyBySlug(@PathVariable String slug) {
        CaseStudyDetailDto caseStudyDetailDto = caseStudyService.findCaseStudyBySlug(slug);
        return ResponseEntity.ok(caseStudyDetailDto);
    }
}