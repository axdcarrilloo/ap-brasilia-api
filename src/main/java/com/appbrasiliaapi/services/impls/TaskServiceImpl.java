package com.appbrasiliaapi.services.impls;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.domain.repositories.TaskRepository;
import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;
import com.appbrasiliaapi.mappers.TaskMapper;
import com.appbrasiliaapi.mappers.UserMapper;
import com.appbrasiliaapi.services.TaskService;
import com.appbrasiliaapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userSvc;

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
        return TaskMapper.convertToListDto(taskRepository.findByUser(UserMapper.convertToEntityFromViewDto(userSvc.getById(idUser))));
    }

    @Override
    public Long register(TaskRegisterDto taskDto) {
        return taskRepository.save(TaskMapper.convertToEntity(taskDto)).getId();
    }
}
