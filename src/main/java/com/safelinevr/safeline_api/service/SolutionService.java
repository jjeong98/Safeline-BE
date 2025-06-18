package com.safelinevr.safeline_api.service;

import com.safelinevr.safeline_api.entity.Solution;
import com.safelinevr.safeline_api.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 만들어줍니다.
@Service // 이 클래스가 비즈니스 로직을 담당하는 서비스임을 나타냅니다.
public class SolutionService {

    private final SolutionRepository solutionRepository; // '창고 관리인'을 불러옵니다.

    public List<Solution> getAllSolutions() {
        // 모든 솔루션 목록을 가져오는 로직입니다.
        return solutionRepository.findAll();
    }
}