package com.dave.taskmanagementsystem.mapper;

import com.dave.taskmanagementsystem.dto.CreateTaskRequest;
import com.dave.taskmanagementsystem.dto.TaskResponse;
import com.dave.taskmanagementsystem.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TaskMapper {
    Task toEntity(CreateTaskRequest request);
    TaskResponse toResponse(Task task);
}
