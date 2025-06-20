package com.safelinevr.safeline_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data 어노테이션을 아래와 같이 분리합니다.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseStudyDto {
    private String id;
    private String clientName;
    private String clientLogo;
    private String impactHeadline;
}