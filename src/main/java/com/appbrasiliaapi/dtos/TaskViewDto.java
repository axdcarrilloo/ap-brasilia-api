package com.appbrasiliaapi.dtos;

import com.appbrasiliaapi.domain.entities.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TaskViewDto {
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    private UserEntity user;
}
