package com.safelinevr.safeline_api.controller;

import com.safelinevr.safeline_api.dto.SolutionCategoryDto;
import com.safelinevr.safeline_api.dto.SolutionDetailDto;
import com.safelinevr.safeline_api.service.SolutionService;
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
@RequestMapping("/api/solutions")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    public ResponseEntity<Map<String, List<SolutionCategoryDto>>> getAllSolutions() {
        List<SolutionCategoryDto> solutionCategories = solutionService.findAllSolutionsGroupedByCategory();
        Map<String, List<SolutionCategoryDto>> response = new HashMap<>();
        response.put("solutionCategories", solutionCategories);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{link}")
    public ResponseEntity<SolutionDetailDto> getSolutionByLink(@PathVariable String link) {
        SolutionDetailDto solutionDetailDto = solutionService.findSolutionByLink(link);
        return ResponseEntity.ok(solutionDetailDto);
    }
}