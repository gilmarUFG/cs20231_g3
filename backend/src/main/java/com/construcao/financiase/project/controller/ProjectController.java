package com.construcao.financiase.project.controller;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.dto.ProjectResponseDTO;
import com.construcao.financiase.project.enums.Category;
import com.construcao.financiase.project.service.ProjectService;
import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProjectController")
@RequestMapping("/api/v1/projects")
public class ProjectController implements ProjectControllerDocs{

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDTO create(
            @AuthenticationPrincipal AuthenticatedUser authenticatedUser,
            @RequestBody @Valid ProjectRequestDTO projectRequestDTO) {

        return projectService.create(authenticatedUser, projectRequestDTO);
    }

    @PatchMapping("/close-fundraising/{projectId}")
    public ProjectResponseDTO closeFundraisingByUser (@PathVariable Long projectId) {
        return projectService.closeFundraisingByUser(projectId);
    }

    @PatchMapping("/submit-evaluation/{projectId}")
    public ProjectResponseDTO submitProjectForEvaluation (@PathVariable Long projectId) {
        return projectService.submitProjectForEvaluation(projectId);
    }

    @GetMapping("/rewards/{id}")
    public List<RewardDTO> getAllRewards(@PathVariable Long id) {
        return projectService.getAllRewards(id);
    }

    @GetMapping("/category/{category}")
    public List<ProjectResponseDTO> getProjectsByCategory(@PathVariable Category category){
        return projectService.getProjectsByCategory(category);
    }
}
