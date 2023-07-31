package com.construcao.financiase.reward.controller;

import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.exception.AuthenticatedUserMismatchOwnerException;
import com.construcao.financiase.user.dto.AuthenticatedUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rewards Management")
public interface RewardControllerDocs {

    @Operation(summary = "Reward creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success reward creating"),
            @ApiResponse(responseCode = "400", description = "Missing required fields, wrong field range value" +
                    "or reward with the informed value already exists.")
    })
    RewardDTO create(AuthenticatedUser authenticatedUser, Long id, RewardDTO rewardDTO)
            throws AuthenticatedUserMismatchOwnerException;

}
