package com.construcao.financiase.users.service;

import com.construcao.financiase.config.ApplicationConfig;
import com.construcao.financiase.user.dto.MessageDTO;
import com.construcao.financiase.user.dto.UserDTO;
import com.construcao.financiase.user.entity.User;
import com.construcao.financiase.user.enums.Role;
import com.construcao.financiase.user.exception.UserNameAlreadyExistsException;
import com.construcao.financiase.user.exception.UserNotFoundException;
import com.construcao.financiase.user.mapper.UserMapper;
import com.construcao.financiase.user.repository.UserRepository;
import com.construcao.financiase.user.service.AuthenticationService;
import com.construcao.financiase.user.service.JwtService;
import com.construcao.financiase.user.service.UserService;
import com.construcao.financiase.users.builder.UserDTOBuilder;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private JwtService jwtService;

    @InjectMocks
    private ApplicationConfig applicationConfig;

    @InjectMocks
    private AuthenticationService authenticationService;

    private UserDTOBuilder userDTOBuilder;

    @BeforeEach
    void setUp(){
        userDTOBuilder = UserDTOBuilder.builder().build();
    }

    @Test
    void whenNewUserIsInformedThenItShouldBeCreated(){
        UserDTO createdUserDTO = userDTOBuilder.buildUserDTO();
        User createdUser = userMapper.toModel(createdUserDTO);
        createdUser.setRole(Role.USER);
        String expectedCreationMessage = "User gabriel@teste.com with ID 9 was successfully created";

        String expectedUsername = createdUserDTO.getUsername();
        String expectedEmail = createdUserDTO.getEmail();

        Mockito.when(userRepository.findByUsername(expectedUsername)).thenReturn(Optional.empty());
        Mockito.when(userRepository.findByEmail(expectedEmail)).thenReturn(Optional.empty());
        Mockito.when((passwordEncoder.encode(createdUser.getPassword()))).thenReturn(createdUser.getPassword());
        Mockito.when(userRepository.save(createdUser)).thenReturn(createdUser);

        MessageDTO creationMessage = userService.create(createdUserDTO, Role.USER);

        MatcherAssert.assertThat(expectedCreationMessage, Matchers.is(Matchers.equalTo(creationMessage.getMessage())));
    }

    @Test
    void whenExistingUsernameIsInformedThenAnExceptionShouldBeThrown(){
        UserDTO duplicatedUserDTO = userDTOBuilder.buildUserDTO();
        User duplicatedUser = userMapper.toModel(duplicatedUserDTO);

        String expectedUsername = duplicatedUserDTO.getUsername();

        Mockito.when(userRepository.findByUsername(expectedUsername))
                .thenReturn(Optional.of(duplicatedUser));

        Assertions.assertThrows(UserNameAlreadyExistsException.class, () -> userService.create(duplicatedUserDTO, Role.USER));

    }

    @Test
    void whenExistingEmailIsInformedThenAnExceptionShouldBeThrown(){
        UserDTO duplicatedUserDTO = userDTOBuilder.buildUserDTO();
        User duplicatedUser = userMapper.toModel(duplicatedUserDTO);

        String expectedUsername = duplicatedUserDTO.getUsername();

        Mockito.when(userRepository.findByUsername(expectedUsername))
                .thenReturn(Optional.of(duplicatedUser));

        Assertions.assertThrows(UserNameAlreadyExistsException.class, () -> userService.create(duplicatedUserDTO, Role.USER));

    }

    @Test
    void whenValidUserIsInformedThenItShouldBeDeleted(){
        UserDTO deletedUserDTO = userDTOBuilder.buildUserDTO();
        User deletedUser = userMapper.toModel(deletedUserDTO);
        var deletedUserId = deletedUserDTO.getId();

        Mockito.when(userRepository.findById(deletedUserId)).thenReturn(Optional.of(deletedUser));
        Mockito.doNothing().when(userRepository).deleteById(deletedUserId);

        userService.delete(deletedUserId);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(deletedUserId);

    }

    @Test
    void whenInvalidUserIsInformedThenAnExceptionShouldBeThrown(){
        UserDTO deletedUserDTO = userDTOBuilder.buildUserDTO();
        var deletedUserId = deletedUserDTO.getId();

        Mockito.when(userRepository.findById(deletedUserId)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> userService.delete(deletedUserId));

    }

    @Test
    void whenExistingUserIsInformedThenItShouldBeUpdated() {
        UserDTO updatedUserDTO = userDTOBuilder.buildUserDTO();
        updatedUserDTO.setUsername("gabrielUpdate");
        User updateduser = userMapper.toModel(updatedUserDTO);
        String updatedMessage = "User gabriel@teste.com with ID 9 was successfully updated";

        Mockito.when(userRepository.findById(updatedUserDTO.getId())).thenReturn(Optional.of(updateduser));
        Mockito.when((passwordEncoder.encode(updateduser.getPassword()))).thenReturn(updateduser.getPassword());
        Mockito.when(userRepository.save(updateduser)).thenReturn(updateduser);

        MessageDTO successUpdatesMessage = userService.update(updatedUserDTO.getId(), updatedUserDTO);

        MatcherAssert.assertThat(successUpdatesMessage.getMessage(),
                Matchers.is(Matchers.equalTo(updatedMessage)));
    }
}
