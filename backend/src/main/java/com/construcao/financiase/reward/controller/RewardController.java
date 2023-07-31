package com.construcao.financiase.reward.controller;

import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.exception.AuthenticatedUserMismatchOwnerException;
import com.construcao.financiase.reward.service.RewardService;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController("RewardController")
@RequestMapping("/api/v1/rewards")
public class RewardController implements RewardControllerDocs{

    private RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public RewardDTO create(
            @AuthenticationPrincipal AuthenticatedUser authenticatedUser,
            @PathVariable Long id,
            @RequestBody @Valid RewardDTO rewardDTO)
            throws AuthenticatedUserMismatchOwnerException {

        return rewardService.create(authenticatedUser, id, rewardDTO);

    }
}
