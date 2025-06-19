package com.safelinevr.safeline_api.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionDetailDto {
    private Long id;
    private String categoryTitle;
    private String name;
    private String tagline;
    private String image;
    // 향후 상세 설명, 스펙 등의 필드를 여기에 추가할 수 있습니다.
    // private String description;
    // private List<String> specifications;
}