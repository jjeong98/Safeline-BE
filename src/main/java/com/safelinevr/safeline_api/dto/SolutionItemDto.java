package com.safelinevr.safeline_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolutionItemDto {
    private String id;
    private String name;
    private String tagline;
    private String image;
}