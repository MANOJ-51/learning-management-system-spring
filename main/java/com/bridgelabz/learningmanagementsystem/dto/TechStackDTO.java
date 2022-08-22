package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TechStackDTO {
    @NotNull(message = "not null")
    private String techName;
    @NotNull(message = "not null")
    private String status;
}
