package com.example.michaeltraining.user;

import com.example.michaeltraining.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("User with id = " + id + " doesn't exist in Database");
        }
    }

}
