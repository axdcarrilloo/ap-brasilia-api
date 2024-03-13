package com.appbrasiliaapi.controllers;

import com.appbrasiliaapi.dtos.MainResponseDto;
import com.appbrasiliaapi.dtos.UserRegisterDto;
import com.appbrasiliaapi.services.UserService;
import com.appbrasiliaapi.utils.Constants;
import com.appbrasiliaapi.utils.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Route.URL_BASE+Route.USER)
public class UserController {

    @Autowired
    private UserService userSvc;

    @GetMapping(value = Route.GET_BYID)
    public ResponseEntity<MainResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.CONSULTATION_SUCCESS)
                .response(userSvc.getById(id))
                .build(), HttpStatus.OK)
        ;
    }

    @GetMapping(value = Route.GETALL)
    public ResponseEntity<MainResponseDto> getAll() {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.CONSULTATION_SUCCESS)
                .response(userSvc.getAll())
                .build(), HttpStatus.OK)
        ;
    }

    @PostMapping(value = Route.REGISTER)
    public ResponseEntity<MainResponseDto> register(@RequestBody UserRegisterDto userDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .message(Constants.REGISTER_SUCCESS)
                .response(userSvc.register(userDto))
                .build(), HttpStatus.CREATED)
        ;
    }
}
