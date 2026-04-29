package com.dave.taskmanagementsystem.controller;

import com.dave.taskmanagementsystem.dto.CreateTaskRequest;
import com.dave.taskmanagementsystem.dto.TaskResponse;
import com.dave.taskmanagementsystem.dto.UpdateTaskStatusRequest;
import com.dave.taskmanagementsystem.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody CreateTaskRequest request){
        return taskService.createTask(request);
    }
    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable UUID id){
        return taskService.getTaskById(id);
    }
    @PatchMapping("/{id}/status")
    public TaskResponse updateTaskStatus(@PathVariable UUID id, @Valid @RequestBody UpdateTaskStatusRequest request){
        return taskService.updateTaskStatus(id, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{userId}")
    public List<TaskResponse> getTasksByUserId(@PathVariable UUID userId){
        return taskService.getTasksByUserId(userId);
    }
}
