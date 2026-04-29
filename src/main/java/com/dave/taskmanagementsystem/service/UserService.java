package com.dave.taskmanagementsystem.service;

import com.dave.taskmanagementsystem.dto.CreateUserRequest;
import com.dave.taskmanagementsystem.dto.UserResponse;
import com.dave.taskmanagementsystem.entity.User;
import com.dave.taskmanagementsystem.exception.EmailAlreadyExistsException;
import com.dave.taskmanagementsystem.exception.ResourceNotFoundException;
import com.dave.taskmanagementsystem.mapper.UserMapper;
import com.dave.taskmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists");

        }
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
    public List<UserResponse> getAllUsers(){
       return userRepository.findAll()
               .stream()
               .map(userMapper::toResponse)
               .toList();
    }
    public UserResponse findUserById(UUID id){
        User user = userRepository.findById(id)
                .orElseThrow (()->new ResourceNotFoundException("User not found"));
        return userMapper.toResponse(user);

    }
    public void deleteUser(UUID id){
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User doesn't exist"));
        userRepository.delete(user);
    }
}
