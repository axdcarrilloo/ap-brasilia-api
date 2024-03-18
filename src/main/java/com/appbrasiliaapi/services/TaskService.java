package com.appbrasiliaapi.services;

import com.appbrasiliaapi.dtos.TaskChangeStatusDto;
import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;

import java.util.List;
import java.util.Map;

public interface TaskService {
    Long deleteByIdUSer(TaskDeleteByIdTaskAndIdUserDto taskDelete);
    TaskViewDto changeToCompleted(TaskChangeStatusDto taskDto);
    List<TaskViewDto> getByIdUser(Long idUser);
    Map<String, Object> register(TaskRegisterDto taskDto);
}
