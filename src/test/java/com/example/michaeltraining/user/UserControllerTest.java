package com.example.michaeltraining.user;

import org.junit.jupiter.api.BeforeEach;
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

    private UserDTO miklDTO;
    private UserDTO olgaDTO;

    @BeforeEach
    void createDTOForTestingUserControllerMethods() {
        miklDTO = new UserDTO();
        miklDTO.setName("Mikl");
        miklDTO.setSurname("Tkach");
        miklDTO.setAge(41L);

        olgaDTO = new UserDTO();
        olgaDTO.setName("Olga");
        olgaDTO.setSurname("Tkach");
        olgaDTO.setAge(39L);
    }

    @Test
    @DisplayName("Should return positive answer when expected and created data for user are equals")
    void getUserMethodTestPositiveCase() throws Exception {

        when(userService.getUser(7L)).thenReturn(miklDTO);

        this.mockMvc.perform(
                        get("/api/v1/users/{id}", 7))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mikl"))
                .andExpect(jsonPath("$.surname").value("Tkach"))
                .andExpect(jsonPath("$.age").value(41L));

    }
}
