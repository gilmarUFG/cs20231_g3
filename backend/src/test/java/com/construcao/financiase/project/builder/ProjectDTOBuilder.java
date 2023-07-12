package com.construcao.financiase.project.builder;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.enums.Category;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ProjectDTOBuilder {

    @Builder.Default
    private final Long id = 4L;

    @Builder.Default
    private final String title = "Meu projeto";

    @Builder.Default
    private final String subtitle = "Meu projeto";

    @Builder.Default
    private final String description = "Meu projeto";

    @Builder.Default
    private final Category category = Category.ARTS;

    @Builder.Default
    private final Double fundraisingGoal = 100.0;

    @Builder.Default
    private final LocalDate endDate = LocalDate.of(2023, 10, 1);

    public ProjectRequestDTO buildProjectDTO(){
        return new ProjectRequestDTO(id, title, subtitle, description, category, fundraisingGoal, endDate);
    }
}
