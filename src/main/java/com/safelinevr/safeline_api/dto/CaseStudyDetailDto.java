package com.safelinevr.safeline_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseStudyDetailDto {
    private Long id;
    private String clientName;
    private String clientLogo;
    private String impactHeadline;
}