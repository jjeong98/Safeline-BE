package com.safelinevr.safeline_api;

import com.safelinevr.safeline_api.entity.CaseStudy; // import 추가
import com.safelinevr.safeline_api.entity.Solution;
import com.safelinevr.safeline_api.repository.CaseStudyRepository; // import 추가
import com.safelinevr.safeline_api.repository.SolutionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SafelineApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafelineApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(SolutionRepository solutionRepository, CaseStudyRepository caseStudyRepository) {
        return args -> {
            // Solution 데이터가 없을 경우에만 초기 데이터 삽입
            if (solutionRepository.count() == 0) {
                Solution solution1 = Solution.builder().categoryTitle("하드웨어 솔루션").name("SAFELINE M4D").tagline("세상에서 가장 스마트한 XR 4D 시뮬레이터").image("/images/solutions/solution_m4d.jpg").link("safeline-m4d").build();
                Solution solution2 = Solution.builder().categoryTitle("소프트웨어 & 플랫폼").name("Total Management System (TMS)").tagline("단 한 명의 교육자가 실현하는 완벽한 VR 집체교육").image("/images/solutions/solution_tms.jpg").link("tms").build();
                solutionRepository.saveAll(Arrays.asList(solution1, solution2));
            }

            // CaseStudy 데이터가 없을 경우에만 초기 데이터 삽입
            if (caseStudyRepository.count() == 0) {
                CaseStudy case1 = CaseStudy.builder().slug("samsung-cnt").clientName("삼성물산").clientLogo("/assets/logos/samsung_cnt.png").impactHeadline("전국 현장 교육 표준화 달성").build();
                CaseStudy case2 = CaseStudy.builder().slug("komipo").clientName("한국중부발전").clientLogo("/assets/logos/komipo.png").impactHeadline("사고 대응 능력 2.5배 향상").build();
                CaseStudy case3 = CaseStudy.builder().slug("lotte-hrd").clientName("롯데인재개발원").clientLogo("/assets/logos/lotte_hrd.png").impactHeadline("교육 몰입도 98% 달성").build();
                caseStudyRepository.saveAll(Arrays.asList(case1, case2, case3));
            }
        };
    }
}