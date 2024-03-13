package com.appbrasiliaapi.dtos;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserViewDto {
    private Long id;
    private String userName;
}
