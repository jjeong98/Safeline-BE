package com.safelinevr.safeline_api.repository;

import com.safelinevr.safeline_api.entity.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy, Long> {
}