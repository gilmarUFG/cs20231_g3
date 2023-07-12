package com.construcao.financiase.users.controller;

import com.construcao.financiase.user.controller.UserController;
import com.construcao.financiase.user.dto.MessageDTO;
import com.construcao.financiase.user.dto.UserDTO;
import com.construcao.financiase.user.enums.Role;
import com.construcao.financiase.user.service.UserService;
import com.construcao.financiase.users.builder.JwtRequestBuilder;
import com.construcao.financiase.users.builder.UserDTOBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static com.construcao.financiase.utils.JsonConversionUtils.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private static final String USERS_API_URL_PATH = "/api/v1/users";

    private MockMvc mockMvc;

    @Mock
    private UserService userService;


    @InjectMocks
    private UserController userController;

    private UserDTOBuilder userDTOBuilder;

    private JwtRequestBuilder jwtRequestBuilder;

    @BeforeEach
    void setUp() {
        userDTOBuilder = UserDTOBuilder.builder().build();
        jwtRequestBuilder = JwtRequestBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTItsCalledThenCreatedStatusShouldBeReturned() throws Exception {
        UserDTO userToCreateDTO = userDTOBuilder.buildUserDTO();
        String creationMessage = "User gabriel@teste.com with ID 9 was successfully created";
        MessageDTO creationMessageDTO = MessageDTO.builder().message(creationMessage).build();

        Mockito.when(userService.createUser(userToCreateDTO)).thenReturn(creationMessageDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(USERS_API_URL_PATH + "/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userToCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message", Matchers.is(creationMessage)));
    }

    @Test
    void whenPOSTItsCalledWithoutRequiredFiedlThanBadRequestShouldBeReturned() throws Exception {
        UserDTO userToCreateDTO = userDTOBuilder.buildUserDTO();
        userToCreateDTO.setUsername(null);

        mockMvc.perform(MockMvcRequestBuilders.post(USERS_API_URL_PATH + "/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userToCreateDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenDELETEIsCalledThenNoContentShoulBeInformed() throws Exception {
        UserDTO userToDeleteDTO = userDTOBuilder.buildUserDTO();
        var userToDeleteId= userToDeleteDTO.getId();

        Mockito.doNothing().when(userService).delete(userToDeleteId);

        mockMvc.perform(MockMvcRequestBuilders.delete(USERS_API_URL_PATH + "/" + userToDeleteId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    void whenPUTItsCalledThenOkStatusShouldBeReturned() throws Exception {
        UserDTO userToUpdateDTO = userDTOBuilder.buildUserDTO();
        userToUpdateDTO.setUsername("gabrielupdate");
        String updatedMessage = "User gabrielupdate with ID 9 is successfully updated";
        MessageDTO updatedMessageDTO = MessageDTO.builder().message(updatedMessage).build();

        var userToUpdateId = userToUpdateDTO.getId();

        Mockito.when(userService.update(userToUpdateId, userToUpdateDTO)).thenReturn(updatedMessageDTO);

        mockMvc.perform(MockMvcRequestBuilders.put(USERS_API_URL_PATH + "/" + userToUpdateId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userToUpdateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is(updatedMessage)));
    }

    /*@Test
    void whenPOSTIsCalledToAuthenticateUserThenOkShouldBeReturned() throws Exception {
        JwtRequest jwtRequest = jwtRequestBuilder.builJwtRequest();
        JwtResponse expectedJwtToken = JwtResponse.builder().jwtToken("fakeToken").build();

        Mockito.when(authenticationService.createAuthenticationToken(jwtRequest)).thenReturn(expectedJwtToken);

        mockMvc.perform(MockMvcRequestBuilders.post(USERS_API_URL_PATH + "/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(jwtRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwtToken", Matchers.is(expectedJwtToken.getJwtToken())));
    }

    @Test
    void whenPOSTIsCalledToAuthenticateUserWithoutPasswordThenBadRequestShouldBeReturned() throws Exception {
        JwtRequest jwtRequest = jwtRequestBuilder.builJwtRequest();
        jwtRequest.setPassword(null);

        mockMvc.perform(MockMvcRequestBuilders.post(USERS_API_URL_PATH + "/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(jwtRequest)))
                .andExpect(status().isBadRequest());
    }*/
}
