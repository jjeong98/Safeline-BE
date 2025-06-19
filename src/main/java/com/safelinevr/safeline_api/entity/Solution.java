package com.safelinevr.safeline_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor



public class Solution {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryTitle; // 카테고리
    private String name; // 제품명
    private String tagline; // 제품 소개
    private String image; // 이미지 파일 경로
    private String link; // 상세 페이지 경로
}