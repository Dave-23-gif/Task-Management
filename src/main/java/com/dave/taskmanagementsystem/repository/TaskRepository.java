package com.dave.taskmanagementsystem.repository;

import com.dave.taskmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByAssignedUserId(UUID assignedUserId);
}
