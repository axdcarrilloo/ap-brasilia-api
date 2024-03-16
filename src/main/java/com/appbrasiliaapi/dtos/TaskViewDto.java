package com.appbrasiliaapi.dtos;

import com.appbrasiliaapi.domain.entities.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    private UserEntity user;
}
