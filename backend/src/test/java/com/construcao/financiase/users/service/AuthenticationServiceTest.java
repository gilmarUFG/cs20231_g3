package com.construcao.financiase.users.service;

import com.construcao.financiase.user.dto.UserDTO;
import com.construcao.financiase.user.entity.User;
import com.construcao.financiase.user.mapper.UserMapper;
import com.construcao.financiase.user.repository.UserRepository;
import com.construcao.financiase.users.builder.JwtRequestBuilder;
import com.construcao.financiase.users.builder.UserDTOBuilder;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
/*
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenManager jwtTokenManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    private UserDTOBuilder userDTOBuilder;

    private JwtRequestBuilder jwtRequestBuilder;

    @BeforeEach
    void setUp() {
        userDTOBuilder = UserDTOBuilder.builder().build();
        jwtRequestBuilder = JwtRequestBuilder.builder().build();
    }

    @Test
    void whenUsernameAndPasswordIsInformedThenATokenShouldBeGenerated() {
        JwtRequest jwtRequest = jwtRequestBuilder.builJwtRequest();
        UserDTO foundUserDTO = userDTOBuilder.buildUserDTO();
        User foundUser = userMapper.toModel(foundUserDTO);
        String expectedGeneratedToken = "fakeToken";

        Mockito.when(userRepository.findByUsername(jwtRequest.getUsername())).thenReturn(Optional.of(foundUser));
        Mockito.when(jwtTokenManager.generateToken(ArgumentMatchers.any(UserDetails.class))).thenReturn(expectedGeneratedToken);

        JwtResponse generatedTokenResponse = authenticationService.createAuthenticationToken(jwtRequest);

        MatcherAssert.assertThat(generatedTokenResponse.getJwtToken(), Matchers.is(Matchers.equalTo(expectedGeneratedToken)));
    }

    @Test
    void whenUsernameIsInformedThenUserShouldBeReturned() {
        UserDTO foundUserDTO = userDTOBuilder.buildUserDTO();
        User foundUser = userMapper.toModel(foundUserDTO);
        SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("ROLE_" + foundUserDTO.getRole().getDescription());
        String username = foundUserDTO.getUsername();

        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.of(foundUser));

        UserDetails userDetails = authenticationService.loadUserByUsername(username);

        MatcherAssert.assertThat(userDetails.getUsername(), Matchers.equalTo(foundUser.getUsername()));
        MatcherAssert.assertThat(userDetails.getPassword(), Matchers.equalTo(foundUser.getPassword()));
        Assertions.assertTrue(userDetails.getAuthorities().contains(userRole));
    }

    @Test
    void whenInvalidUsernameIsInformedThenAnExceptionShouldBeThrown() {
        UserDTO foundUserDTO = userDTOBuilder.buildUserDTO();
        String username = foundUserDTO.getUsername();

        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class, () -> authenticationService.loadUserByUsername(username));
    }

 */
}
