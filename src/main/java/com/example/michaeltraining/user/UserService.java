package com.example.michaeltraining.user;

import com.example.michaeltraining.exception.NotFoundException;

public interface UserService {
    UserDTO getUser(Long id);

    void saveUser(UserDTO dto);

    void updateUser(Long id, UserDTO dto);

    void deleteUser(Long id) throws RuntimeException;
}
