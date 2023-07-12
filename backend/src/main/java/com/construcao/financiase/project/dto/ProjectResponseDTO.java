package com.construcao.financiase.project.dto;

import com.construcao.financiase.project.enums.Category;
import com.construcao.financiase.project.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {

    private Long id;

    private String title;

    private String subtitle;

    private String description;

    private Category category;

    private Status status;

    private Double fundraisingGoal;

    private LocalDate startDate;

    private LocalDate endDate;
}
