package com.appbrasiliaapi.services;

import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;

import java.util.List;

public interface TaskService {
    Long deleteByIdUSer(TaskDeleteByIdTaskAndIdUserDto taskDelete);
    TaskViewDto changeToCompleted(TaskViewDto taskDto);
    List<TaskViewDto> getByIdUser(Long idUser);
    Long register(TaskRegisterDto taskDto);
}
