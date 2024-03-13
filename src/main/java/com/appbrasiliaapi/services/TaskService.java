package com.appbrasiliaapi.services;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;

import java.util.List;

public interface TaskService {
    //TaskEntity getByIdTaskAndIdUser(TaskDeleteByIdTaskAndIdUserDto task);
    Long deleteByIdUSer(TaskDeleteByIdTaskAndIdUserDto taskDelete);
    TaskViewDto changeToCompleted(TaskViewDto taskDto);
    List<TaskViewDto> getByIdUser(Long idUser);
    Long register(TaskRegisterDto taskDto);
}
