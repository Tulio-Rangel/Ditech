package com.tulio.backenduserservice.service;

import com.tulio.backenduserservice.exception.ResourceNotFoundException;
import com.tulio.backenduserservice.model.User;
import com.tulio.backenduserservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("Test User");
        user.setEmail("test@example.com");
    }

    @Test
    void saveUser_shouldSaveAndReturnUser() {
        // Arrange
        User userToSave = new User();
        userToSave.setUsername("Test User");
        userToSave.setEmail("test@example.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername(userToSave.getUsername());
        savedUser.setEmail(userToSave.getEmail());

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User result = userService.saveUser(userToSave);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test User", result.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getUserById_whenUserNotFound_shouldThrowException() {
        // Arrange
        long userId = 1L;
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            userService.getUserById(userId);
        });

        verify(userRepository, times(1)).findById(userId);
    }
}
