package com.safelinevr.safeline_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "case_studies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String slug; // 상세 페이지 URL을 위한 고유 값 (예: "samsung-cnt")

    @Column(nullable = false)
    private String clientName;

    private String clientLogo;

    @Column(nullable = false)
    private String impactHeadline;
}