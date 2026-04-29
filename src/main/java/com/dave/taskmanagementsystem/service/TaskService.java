package com.dave.taskmanagementsystem.service;

import com.dave.taskmanagementsystem.dto.CreateTaskRequest;
import com.dave.taskmanagementsystem.dto.TaskResponse;
import com.dave.taskmanagementsystem.dto.UpdateTaskStatusRequest;
import com.dave.taskmanagementsystem.entity.Task;
import com.dave.taskmanagementsystem.entity.User;
import com.dave.taskmanagementsystem.enums.StatusEnum;
import com.dave.taskmanagementsystem.exception.ResourceNotFoundException;
import com.dave.taskmanagementsystem.mapper.TaskMapper;
import com.dave.taskmanagementsystem.repository.TaskRepository;
import com.dave.taskmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    public TaskResponse createTask(CreateTaskRequest request){
        User assignedUser=userRepository.findById(request.getAssignedUserId())
                .orElseThrow(()->new ResourceNotFoundException("User doesn't exist"));
        Task task=taskMapper.toEntity(request);
        task.setAssignedUser(assignedUser);
        task.setStatus(StatusEnum.PENDING);
        Task savedTask= taskRepository.save(task);
        return taskMapper.toResponse(task);

    }
    public List<TaskResponse> getAllTasks(){
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }
    public TaskResponse getTaskById(UUID id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Task doesn't exist"));
        return taskMapper.toResponse(task);
    }
    public  TaskResponse updateTaskStatus(UUID id, UpdateTaskStatusRequest request){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Task doesn't exist"));
        task.setStatus(request.getStatus());
        Task updatedTask=taskRepository.save(task);
        return taskMapper.toResponse(task);

    }
    public void deleteTask(UUID id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Task doesn't exist"));
        taskRepository.delete(task);
    }
    public List<TaskResponse> getTasksByUserId(UUID userId){
       return taskRepository.findByAssignedUserId(userId)
                .stream()
                .map(taskMapper::toResponse)
                .toList();

    }

}
