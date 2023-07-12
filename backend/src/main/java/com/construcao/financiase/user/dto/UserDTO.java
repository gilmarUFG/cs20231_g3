package com.construcao.financiase.user.dto;

import com.construcao.financiase.user.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String username;

    @NotNull
    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 15)
    private String password;

}

