package com.safelinevr.safeline_api.controller;

import com.safelinevr.safeline_api.entity.Solution;
import com.safelinevr.safeline_api.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SolutionController {

    private final SolutionService solutionService; 

    // GET 방식으로 /api/solutions 라는 주소로 요청이 오면 이 메소드가 실행됩니다.
    @GetMapping("/api/solutions")
    public List<Solution> getSolutions() {
        return solutionService.getAllSolutions();
    }
}