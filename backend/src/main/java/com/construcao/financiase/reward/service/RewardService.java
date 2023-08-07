package com.construcao.financiase.reward.service;

import com.construcao.financiase.project.entity.Project;
import com.construcao.financiase.project.enums.Status;
import com.construcao.financiase.project.service.ProjectService;
import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.entity.Reward;
import com.construcao.financiase.reward.exception.AuthenticatedUserMismatchOwnerException;
import com.construcao.financiase.reward.exception.RewardAlreadyExistsException;
import com.construcao.financiase.reward.exception.RewardCreationDeniedException;
import com.construcao.financiase.reward.mapper.RewardMapper;
import com.construcao.financiase.reward.repository.RewardRepository;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import com.construcao.financiase.user.entity.User;
import com.construcao.financiase.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardService {

    private final static RewardMapper rewardMapper = RewardMapper.INSTANCE;

    private RewardRepository rewardRepository;

    private ProjectService projectService;

    private UserService userService;

    @Autowired
    public RewardService(RewardRepository rewardRepository, ProjectService projectService, UserService userService) {
        this.rewardRepository = rewardRepository;
        this.projectService = projectService;
        this.userService = userService;
    }

    public RewardDTO create(AuthenticatedUser authenticatedUser, Long id, RewardDTO rewardDTO)
            throws AuthenticatedUserMismatchOwnerException {

        Project project = projectService.verifyAndGetProjectIfExists(id);

        if(project.getStatus() != Status.CREATED)
            throw new RewardCreationDeniedException();

        verifyIfAuthenticatedUserIsProjectOwner(authenticatedUser, project);

        verifyIfRewardExists(rewardDTO, project);

        Reward rewardToCreate = rewardMapper.toModel(rewardDTO);
        rewardToCreate.setProject(project);

        Reward createdReward = rewardRepository.save(rewardToCreate);

        return rewardMapper.toDTO(createdReward);
    }

    private void verifyIfAuthenticatedUserIsProjectOwner(AuthenticatedUser authenticatedUser, Project project)
            throws AuthenticatedUserMismatchOwnerException {

        User foundAuthenticatedUser = userService.verifyAndGetUserIfExists(authenticatedUser.getUsername());
        Long authenticatedUserId = foundAuthenticatedUser.getId();
        String userEmail = foundAuthenticatedUser.getEmail();

        if(!userEmail.equalsIgnoreCase(project.getOwner().getEmail()))
            throw new AuthenticatedUserMismatchOwnerException(authenticatedUserId);

    }

    private void verifyIfRewardExists(RewardDTO rewardDTO, Project project) {
        rewardRepository.findByMinValueAndProject(rewardDTO.getMinValue(), project)
                .ifPresent(reward -> {throw new RewardAlreadyExistsException(rewardDTO.getMinValue());
                });
    }
}
