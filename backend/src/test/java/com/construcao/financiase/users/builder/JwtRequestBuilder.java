package com.construcao.financiase.users.builder;

import com.construcao.financiase.config.AuthenticationRequest;
import lombok.Builder;

@Builder
public class JwtRequestBuilder {

    @Builder.Default
    private String username = "karlla";

    @Builder.Default
    private String password = "123456";

    public AuthenticationRequest builJwtRequest() {
        return new AuthenticationRequest(username, password);
    }
}
