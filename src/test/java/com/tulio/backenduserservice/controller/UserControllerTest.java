package com.tulio.backenduserservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tulio.backenduserservice.model.User;
import com.tulio.backenduserservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("Test User");
        user.setEmail("test@example.com");
    }

    @Test
    void getAllUsers_shouldReturnUserList() throws Exception {
        // Arrange
        when(userService.getAllUsers()).thenReturn(Collections.singletonList(user));

        // Act & Assert
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].username").value("Test User"));
    }

    @Test
    void createUser_shouldCreateAndReturnUser() throws Exception {
        // Arrange
        User userToCreate = new User();
        userToCreate.setUsername("New User");
        userToCreate.setEmail("new@example.com");
        userToCreate.setActive(true);

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername(userToCreate.getUsername());
        savedUser.setEmail(userToCreate.getEmail());
        savedUser.setActive(userToCreate.getActive());

        when(userService.saveUser(any(User.class))).thenReturn(savedUser);

        // Act & Assert
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userToCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("New User"));
    }
}
