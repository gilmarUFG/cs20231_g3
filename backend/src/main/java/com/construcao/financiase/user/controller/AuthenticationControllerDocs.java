package com.construcao.financiase.user.controller;

import com.construcao.financiase.config.AuthenticationRequest;
import com.construcao.financiase.config.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication")
public interface AuthenticationControllerDocs {

    @Operation(summary = "User authentication operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success user authenticated"),
            @ApiResponse(responseCode = "400", description = "User not found")
    })
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
