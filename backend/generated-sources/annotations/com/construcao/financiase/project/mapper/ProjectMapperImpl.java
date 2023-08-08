package com.construcao.financiase.project.mapper;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.dto.ProjectResponseDTO;
import com.construcao.financiase.project.entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T21:31:54-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toModel(ProjectRequestDTO projectRequestDTO) {
        if ( projectRequestDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectRequestDTO.getId() );
        project.setTitle( projectRequestDTO.getTitle() );
        project.setSubtitle( projectRequestDTO.getSubtitle() );
        project.setDescription( projectRequestDTO.getDescription() );
        project.setCategory( projectRequestDTO.getCategory() );
        project.setFundraisingGoal( projectRequestDTO.getFundraisingGoal() );
        project.setEndDate( projectRequestDTO.getEndDate() );

        return project;
    }

    @Override
    public Project toModel(ProjectResponseDTO projectRequestDTO) {
        if ( projectRequestDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectRequestDTO.getId() );
        project.setTitle( projectRequestDTO.getTitle() );
        project.setSubtitle( projectRequestDTO.getSubtitle() );
        project.setDescription( projectRequestDTO.getDescription() );
        project.setCategory( projectRequestDTO.getCategory() );
        project.setStatus( projectRequestDTO.getStatus() );
        project.setFundraisingGoal( projectRequestDTO.getFundraisingGoal() );
        project.setStartDate( projectRequestDTO.getStartDate() );
        project.setEndDate( projectRequestDTO.getEndDate() );

        return project;
    }

    @Override
    public ProjectResponseDTO toDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();

        projectResponseDTO.setId( project.getId() );
        projectResponseDTO.setTitle( project.getTitle() );
        projectResponseDTO.setSubtitle( project.getSubtitle() );
        projectResponseDTO.setDescription( project.getDescription() );
        projectResponseDTO.setCategory( project.getCategory() );
        projectResponseDTO.setStatus( project.getStatus() );
        projectResponseDTO.setFundraisingGoal( project.getFundraisingGoal() );
        projectResponseDTO.setStartDate( project.getStartDate() );
        projectResponseDTO.setEndDate( project.getEndDate() );

        return projectResponseDTO;
    }
}
