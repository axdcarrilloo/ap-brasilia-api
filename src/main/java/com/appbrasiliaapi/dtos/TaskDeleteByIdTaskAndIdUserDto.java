package com.appbrasiliaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TaskDeleteByIdTaskAndIdUserDto {
    private Long idTask;
    private Long idUser;
}
