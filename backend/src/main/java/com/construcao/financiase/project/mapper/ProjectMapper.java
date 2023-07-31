package com.construcao.financiase.project.mapper;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.dto.ProjectResponseDTO;
import com.construcao.financiase.project.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toModel(ProjectRequestDTO projectRequestDTO);

    Project toModel(ProjectResponseDTO projectRequestDTO);

    ProjectResponseDTO toDTO(Project project);

}
