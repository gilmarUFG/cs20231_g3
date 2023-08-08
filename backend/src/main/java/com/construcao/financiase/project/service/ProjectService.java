package com.construcao.financiase.project.service;

import com.construcao.financiase.project.dto.ProjectRequestDTO;
import com.construcao.financiase.project.dto.ProjectResponseDTO;
import com.construcao.financiase.project.entity.Project;
import com.construcao.financiase.project.enums.Category;
import com.construcao.financiase.project.enums.Status;
import com.construcao.financiase.project.exception.ProjectAlreadyExistsException;
import com.construcao.financiase.project.exception.ProjectNotFoundException;
import com.construcao.financiase.project.exception.StatusNotAllowedException;
import com.construcao.financiase.project.mapper.ProjectMapper;
import com.construcao.financiase.project.repository.ProjectRepository;
import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.entity.Reward;
import com.construcao.financiase.reward.exception.RewardNotFoundException;
import com.construcao.financiase.reward.mapper.RewardMapper;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import com.construcao.financiase.user.entity.User;
import com.construcao.financiase.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final static ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    private final static RewardMapper rewardMapper = RewardMapper.INSTANCE;

    private ProjectRepository projectRepository;

    private UserService userService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    public ProjectResponseDTO create(AuthenticatedUser authenticatedUser, ProjectRequestDTO projectRequestDTO){

        User foundAuthenticatedUser = userService.verifyAndGetUserIfExists(authenticatedUser.getUsername());

        verifyIfExists(projectRequestDTO.getTitle());

        Project projectToCreate = projectMapper.toModel(projectRequestDTO);

        projectToCreate.setOwner(foundAuthenticatedUser);
        projectToCreate.setStatus(Status.CREATED);

        Project createdProject = projectRepository.save(projectToCreate);

        return projectMapper.toDTO(createdProject);
    }

    public List<RewardDTO> getAllRewards(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        List<Reward> rewardList = project.getRewards();

        if(rewardList.isEmpty())
            throw new RewardNotFoundException(project.getId());

        return rewardList.stream()
                .map(rewardMapper::toDTO)
                .collect(Collectors.toList());
    }


    public List<ProjectResponseDTO> getProjectsByCategory(Category category) {

        Optional<List<Project>> optionalProjectList = projectRepository.findByCategory(category);

        if(optionalProjectList.isEmpty())
            throw new NoSuchElementException();

        List<Project> projectsList = optionalProjectList.get();

        if(projectsList.isEmpty())
            throw new ProjectNotFoundException(category);

        return projectsList.stream()
                .map((projectMapper::toDTO))
                .collect(Collectors.toList());

    }

    public ProjectResponseDTO closeFundraisingByUser(Long id) {

        Project project = verifyAndGetProjectIfExists(id);

        if(LocalDate.now().isAfter(project.getEndDate()))
            throw new StatusNotAllowedException("O status do projeto não pode ser alterado pois o período de arrecadação" +
                    "da campanha está encerrado.");

        // TODO: 16/06/2023
        //if(projeto já possuir arrecadação)
        //    throw new StatusNotAllowedException("O projeto não poderá ser encerrado pois ele já recebeu contribuições");

        project.setStatus(Status.CLOSED);

        projectRepository.save(project);

        return projectMapper.toDTO(project);
    }

    public ProjectResponseDTO submitProjectForEvaluation(Long id) {

        Project project = verifyAndGetProjectIfExists(id);

        if(project.getStatus() != Status.CREATED)
            throw new StatusNotAllowedException("Status não permitido ou o projeto já foi avaliado!");

        if(project.getRewards().isEmpty())
            throw new StatusNotAllowedException("Não é possível enviar para avaliação sem recompensas cadastradas.");

        project.setStatus(Status.PENDING);

        projectRepository.save(project);

        return projectMapper.toDTO(project);
    }

    public Project verifyAndGetProjectIfExists(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    private void verifyIfExists(String titleProject) {
        projectRepository.findByTitle(titleProject)
                .ifPresent(project -> {throw new ProjectAlreadyExistsException(project.getTitle()); });
    }

}
