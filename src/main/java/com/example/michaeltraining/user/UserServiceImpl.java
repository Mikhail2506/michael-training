package com.example.michaeltraining.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUser(Long id) {
        return userMapper.toDto(
                userRepository.findAllById(id)
        );
    }

    @Override
    public void saveUser(UserDTO dto) {
        final User user = userMapper.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDTO dto) {
        User user = userMapper.toEntity(dto);
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new NoSuchElementException("User with id = " + id + " doesn't exist in Database");
        }
    }

}
