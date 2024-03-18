package com.appbrasiliaapi.services.impls;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.domain.entities.UserEntity;
import com.appbrasiliaapi.domain.repositories.TaskRepository;
import com.appbrasiliaapi.dtos.*;
import com.appbrasiliaapi.mappers.TaskMapper;
import com.appbrasiliaapi.mappers.UserMapper;
import com.appbrasiliaapi.services.TaskService;
import com.appbrasiliaapi.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final UserService userSvc;

    private TaskEntity getById(Long id) {
        log.info("TaskServiceImpl.class - getById() -> Consultando tarea por id");
        return taskRepository.findById(id).orElse(null);
    }
    private TaskEntity getByIdTaskAndIdUser(TaskDeleteByIdTaskAndIdUserDto task) {
        return taskRepository.findByIdAndUser(task.getIdTask(),
                UserMapper.convertToEntityFromViewDto(userSvc.getById(task.getIdUser()))).orElse(null);
    }
    @Override
    public Long deleteByIdUSer(TaskDeleteByIdTaskAndIdUserDto taskDelete) {
        TaskEntity task = getByIdTaskAndIdUser(taskDelete);
        if(task != null) {
            taskRepository.delete(task);
            return taskDelete.getIdTask();
        } else {
            return 0L;
        }
    }
    @Override
    public TaskViewDto changeToCompleted(TaskChangeStatusDto taskDto) {
        TaskEntity taskEntity = getById(taskDto.getId());
        if(taskEntity != null) {
            taskEntity.setStatus(taskDto.getStatus());
            return TaskMapper.convertToDto(taskRepository.save(taskEntity));
        }else return null;
    }
    @Override
    public List<TaskViewDto> getByIdUser(Long idUser) {
        UserViewDto userDto = userSvc.getById(idUser);
        if(userDto != null) {
            return TaskMapper.convertToListDto(taskRepository.findByUser(UserMapper.convertToEntityFromViewDto(userDto)));
        } else return null;
    }

    @Override
    public Map<String, Object> register(TaskRegisterDto taskDto) {
        Map<String, Object> map = new HashMap<>();
        if(userSvc.getById(taskDto.getUser().getId()) != null) {
            map.put("Response", taskRepository.save(TaskMapper.convertToEntity(taskDto)).getId());
            return map;
        } else {
            map.put("errorExistUser", "Usuario no existe");
            return map;
        }
    }
}
