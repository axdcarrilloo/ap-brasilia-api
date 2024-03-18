package com.appbrasiliaapi.dtos;

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
public class TaskChangeStatusDto {
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTask status;
}
