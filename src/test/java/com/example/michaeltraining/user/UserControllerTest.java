package com.example.michaeltraining.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    void shouldReturnUserAndStatus200OkWhenReceivesUserId() throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Mikhail");
        userDTO.setSurname("Toukach");
        userDTO.setAge(41L);

        when(userService.getUser(1L)).thenReturn(userDTO);

        mockMvc.perform(
                        get("/api/v1/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mikhail"))
                .andExpect(jsonPath("$.surname").value("Toukach"))
                .andExpect(jsonPath("$.age").value(41L));

    }
}
