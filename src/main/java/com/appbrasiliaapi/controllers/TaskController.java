package com.appbrasiliaapi.controllers;

import com.appbrasiliaapi.dtos.*;
import com.appbrasiliaapi.services.TaskService;
import com.appbrasiliaapi.utils.Constants;
import com.appbrasiliaapi.utils.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

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
    public ResponseEntity<MainResponseDto> changeToCompleted(@RequestBody TaskChangeStatusDto taskDto) {
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
        Map<String, Object> map = taskSvc.register(taskDto);
        String errorExistUser = (String)map.get("errorExistUser");
        if(errorExistUser != null) {
            return new ResponseEntity<>(MainResponseDto.builder()
                    .message(Constants.REGISTER_FAILED)
                    .response(errorExistUser)
                    .build(), HttpStatus.BAD_REQUEST)
            ;
        } else {
            return new ResponseEntity<>(MainResponseDto.builder()
                    .message(Constants.REGISTER_SUCCESS)
                    .response(map.get("Response"))
                    .build(), HttpStatus.CREATED)
            ;
        }
    }
}
