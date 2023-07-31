package com.construcao.financiase.user.controller;

import com.construcao.financiase.user.dto.MessageDTO;
import com.construcao.financiase.user.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users Management")
public interface UserControllerDocs {

    @Operation(summary = "User creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success user creation"),
            @ApiResponse(responseCode = "400", description = "Missing required field or an erros on validation field")
                    })
    MessageDTO createUser(UserDTO userToCreateDTO);

    @Operation(summary = "User exclusion operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Success user exclusion"),
            @ApiResponse(responseCode = "404", description = "User with informed id not found in the system")
    })
    void delete(@PathVariable Long id);

    @Operation(summary = "User update operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "20", description = "Success user updated"),
            @ApiResponse(responseCode = "400", description = "Missing required field or an erros on validation field")
    })
    MessageDTO update(@PathVariable Long id, @RequestBody @Valid UserDTO userToUpdateDTO);

    /*@Operation(summary = "User authentication operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success user authenticated"),
            @ApiResponse(responseCode = "400", description = "User not found")
    })*/
    //JwtResponse createAuthenticationToken(JwtRequest jwtRequest);
}
