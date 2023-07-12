package com.construcao.financiase.project.controller;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.dto.ProjectResponseDTO;
import com.construcao.financiase.project.enums.Category;
import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Projects Management")
public interface ProjectControllerDocs {

    @Operation(summary = "Project creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success project creating"),
            @ApiResponse(responseCode = "400", description = "Missing required fields, wrong field range value" +
                    "project name already registered")
    })
    ProjectResponseDTO create(AuthenticatedUser authenticatedUser, ProjectRequestDTO projectRequestDTO);

    @Operation(summary = "List all rewards of the project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned all rewards")
    })
    List<RewardDTO> getAllRewards(Long id);

    @Operation(summary = "List projects by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned projects by category")
    })
    List<ProjectResponseDTO> getProjectsByCategory(@PathVariable Category category);

    @Operation(summary = "Project fundraising closed by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Project fundraising successfully closed by user"),
            @ApiResponse(responseCode = "400", description = "Project already received contributions or has an invalid status.")
    })
    ProjectResponseDTO closeFundraisingByUser (@PathVariable Long id);

    @Operation(summary = "Submit project for evaluation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Project successfully submitted for evaluation"),
            @ApiResponse(responseCode = "400", description = "Project already submitted for evaluation or has an invalid status.")
    })
    ProjectResponseDTO submitProjectForEvaluation (@PathVariable Long id);
}
