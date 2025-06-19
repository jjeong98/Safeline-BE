package com.safelinevr.safeline_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseStudyDto {
    private String id;
    private String clientName;
    private String clientLogo;
    private String impactHeadline;
}