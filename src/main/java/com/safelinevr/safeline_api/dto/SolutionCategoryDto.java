package com.safelinevr.safeline_api.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolutionCategoryDto {
    private String title;
    private String description;
    private List<SolutionItemDto> items;
}