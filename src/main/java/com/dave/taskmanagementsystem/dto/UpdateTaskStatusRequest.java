package com.dave.taskmanagementsystem.dto;

import com.dave.taskmanagementsystem.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskStatusRequest {
    private StatusEnum status;
}
