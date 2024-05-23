package com.example.michaeltraining.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserMethodTestPositiveCase() throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Mikhail");
        userDTO.setSurname("Toukach");
        userDTO.setAge(41L);

        when(userService.getUser(1L)).thenReturn(userDTO);

        this.mockMvc.perform(
                        get("/api/v1/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mikhail"))
                .andExpect(jsonPath("$.surname").value("Toukach"))
                .andExpect(jsonPath("$.age").value(41L));

    }

    @Test
    @DisplayName("негативный ответ при отсутствиии пользователя с таким Id")
    void getUserMethodTestNegativeCase() throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Mikhail");
        userDTO.setSurname("Toukach");
        userDTO.setAge(41L);

        when(userService.getUser(1L)).thenReturn(userDTO);

        this.mockMvc.perform(
                        get("/api/v1/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mikhail"))
                .andExpect(jsonPath("$.surname").value("Toukach"))
                .andExpect(jsonPath("$.age").value(41L));

    }
}
