package com.safelinevr.safeline_api;

import com.safelinevr.safeline_api.entity.Solution;
import com.safelinevr.safeline_api.repository.SolutionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SafelineApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafelineApiApplication.class, args);
    }

    // 애플리케이션 시작 시 테스트 데이터를 DB에 저장하는 로직
    @Bean
    public CommandLineRunner initData(SolutionRepository solutionRepository) {
        return args -> {
            Solution solution1 = new Solution();
            solution1.setCategoryTitle("하드웨어 솔루션");
            solution1.setName("SAFELINE M4D");
            solution1.setTagline("세상에서 가장 스마트한 XR 4D 시뮬레이터");
            solution1.setImage("/images/solutions/solution_m4d.jpg");
            solution1.setLink("/solutions/safeline-m4d");
            solutionRepository.save(solution1);

            Solution solution2 = new Solution();
            solution2.setCategoryTitle("하드웨어 솔루션");
            solution2.setName("VR CARRIER");
            solution2.setTagline("최고의 이동형 VR 집체 교육 솔루션");
            solution2.setImage("/images/solutions/solution_carrier.jpg");
            solution2.setLink("/solutions/vr-carrier");
            solutionRepository.save(solution2);
        };
    }
}