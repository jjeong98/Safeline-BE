package com.safelinevr.safeline_api.repository;

import com.safelinevr.safeline_api.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받는 것만으로도, Solution 엔티티에 대한 기본적인 DB 작업(findAll, findById, save 등)이 자동으로 가능해집니다.
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    // <엔티티 클래스 이름, ID 필드의 타입>
}