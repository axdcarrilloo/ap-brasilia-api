package com.appbrasiliaapi.dtos;

import com.appbrasiliaapi.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TaskViewDto {
    private Long id;

    private String title;

    private String description;

    private String status;

    private UserEntity user;
}
