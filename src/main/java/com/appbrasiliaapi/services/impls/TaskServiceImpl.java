package com.appbrasiliaapi.services.impls;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.domain.entities.UserEntity;
import com.appbrasiliaapi.domain.repositories.TaskRepository;
import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;
import com.appbrasiliaapi.dtos.UserViewDto;
import com.appbrasiliaapi.mappers.TaskMapper;
import com.appbrasiliaapi.mappers.UserMapper;
import com.appbrasiliaapi.services.TaskService;
import com.appbrasiliaapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final UserService userSvc;

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
    public TaskViewDto changeToCompleted(TaskViewDto taskDto) {
        return TaskMapper.convertToDto(taskRepository.save(TaskMapper.convertToEntityFromViewDto(taskDto)));
    }
    @Override
    public List<TaskViewDto> getByIdUser(Long idUser) {
        UserViewDto userDto = userSvc.getById(idUser);
        if(userDto != null) {
            return TaskMapper.convertToListDto(taskRepository.findByUser(UserMapper.convertToEntityFromViewDto(userDto)));
        } else return null;
    }

    @Override
    public Long register(TaskRegisterDto taskDto) {
        return taskRepository.save(TaskMapper.convertToEntity(taskDto)).getId();
    }
}
