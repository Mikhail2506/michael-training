package com.example.michaeltraining.user;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDto(User user);

    User toEntity(UserDTO dto);
}
