package com.construcao.financiase.config;

import com.construcao.financiase.user.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {

    private static final String USERS_API_URL = "/api/v1/users/**";
    private static final String AUTH_API_URL = "/api/v1/auth/**";
    private static final String REWARDS_API_URL = "/api/v1/rewards/**";
    private static final String SWAGGER_URL = "/swagger-ui.html";
    private static final String ROLE_ADMIN = Role.ADMIN.name();
    private static final String ROLE_USER = Role.USER.name();

    private static final String[] PUBLIC_PROJECTS_API_URL = {
            "/api/v1/projects/category/**",
            "/api/v1/projects/rewards/**"
    };

    private static final String[] USER_PROJECTS_API_URL = {
            "/api/v1/projects/create",
            "/api/v1/projects/submit-evaluation/**",
            "/api/v1/projects/close-fundraising/**"
    };

    private static final String[] SWAGGER_RESOURCES = {
            // -- swagger ui
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/webjars/**"
    };

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()

                .requestMatchers(SWAGGER_RESOURCES).permitAll()

                .requestMatchers(AUTH_API_URL, USERS_API_URL, SWAGGER_URL).permitAll()

                .requestMatchers(PUBLIC_PROJECTS_API_URL).permitAll()

                .requestMatchers(USER_PROJECTS_API_URL).hasRole(ROLE_USER)

                .requestMatchers(REWARDS_API_URL).hasRole(ROLE_USER)

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return httpSecurity.build();
    }
}
