package com.appbrasiliaapi.controllers;

import com.appbrasiliaapi.dtos.MainResponseDto;
import com.appbrasiliaapi.dtos.TaskDeleteByIdTaskAndIdUserDto;
import com.appbrasiliaapi.dtos.TaskRegisterDto;
import com.appbrasiliaapi.dtos.TaskViewDto;
import com.appbrasiliaapi.services.TaskService;
import com.appbrasiliaapi.utils.Constants;
import com.appbrasiliaapi.utils.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Route.URL_BASE+Route.TASK)
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskSvc;

    @DeleteMapping(value = Route.DELETE)
    public ResponseEntity<MainResponseDto> delete(@RequestBody TaskDeleteByIdTaskAndIdUserDto taskDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.DELETE_SUCCESS)
                .response(taskSvc.deleteByIdUSer(taskDto))
                .build(), HttpStatus.OK)
        ;
    }

    @PostMapping(value = Route.CHANGETO_COMPLETED)
    public ResponseEntity<MainResponseDto> changeToCompleted(@RequestBody TaskViewDto taskDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.UPDATE_SUCCESS)
                .response(taskSvc.changeToCompleted(taskDto))
                .build(), HttpStatus.OK)
        ;
    }

    @GetMapping(value = "/GetByIdUser/{id}")
    public ResponseEntity<MainResponseDto> getByIdUser(@PathVariable Long id) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.CONSULTATION_SUCCESS)
                .response(taskSvc.getByIdUser(id))
                .build(), HttpStatus.OK)
        ;
    }

    @PostMapping(value = Route.REGISTER)
    public ResponseEntity<MainResponseDto> register(@RequestBody TaskRegisterDto taskDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.REGISTER_SUCCESS)
                .response(taskSvc.register(taskDto))
                .build(), HttpStatus.CREATED)
        ;
    }
}
