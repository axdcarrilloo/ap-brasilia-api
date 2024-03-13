package com.appbrasiliaapi.mappers;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.domain.entities.UserEntity;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;
import com.appbrasiliaapi.dtos.UserViewDto;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public static TaskEntity convertToEntityFromViewDto(TaskViewDto taskDto) {
        return TaskEntity.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .user(taskDto.getUser())
                .build()
        ;
    }

    public static TaskViewDto convertToDto(TaskEntity taskEntity) {
        return TaskViewDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .user(taskEntity.getUser())
                .build()
        ;
    }
    public static List<TaskViewDto> convertToListDto(List<TaskEntity> tasks) {
        List<TaskViewDto> tasksDto = new ArrayList<>();
        tasks.forEach(task -> TaskViewDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .user(task.getUser())
        );
        return tasksDto;
    }
    public static TaskEntity convertToEntity(TaskRegisterDto taskDto) {
        return TaskEntity.builder()
                .id(0L)
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .build()
        ;
    }
}
