package com.appbrasiliaapi.services;

import com.appbrasiliaapi.dtos.UserRegisterDto;
import com.appbrasiliaapi.dtos.UserViewDto;

import java.util.List;

public interface UserService {
    UserViewDto getById(Long id);
    List<UserViewDto> getAll();
    Long register(UserRegisterDto user);
}
