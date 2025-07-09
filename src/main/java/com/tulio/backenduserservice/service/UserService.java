package com.tulio.backenduserservice.service;

import com.tulio.backenduserservice.exception.ResourceNotFoundException;
import com.tulio.backenduserservice.model.User;
import com.tulio.backenduserservice.repository.UserRepository;
import com.tulio.backenduserservice.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(Constants.USER_NOT_FOUND_MESSAGE, id)));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(Constants.USER_NOT_FOUND_MESSAGE, id));
        }
        userRepository.deleteById(id);
    }
}
