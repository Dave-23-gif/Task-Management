package com.dave.taskmanagementsystem.mapper;

import com.dave.taskmanagementsystem.dto.CreateUserRequest;
import com.dave.taskmanagementsystem.dto.UserResponse;
import com.dave.taskmanagementsystem.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserRequest request);
    UserResponse toResponse(User user);


}
