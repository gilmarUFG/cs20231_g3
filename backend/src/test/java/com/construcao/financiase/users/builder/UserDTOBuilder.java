package com.construcao.financiase.users.builder;

import com.construcao.financiase.user.dto.UserDTO;
import com.construcao.financiase.user.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
public class UserDTOBuilder {

    @Builder.Default
    private Long id = 9L;

    @Builder.Default
    private String username = "gabriel";

    @Builder.Default
    private String email = "gabriel@teste.com";

    @Builder.Default
    private String password = "12345678";

    public UserDTO buildUserDTO(){
        return new UserDTO(id, username, email, password);
    }
}
