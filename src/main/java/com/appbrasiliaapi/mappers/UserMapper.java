package com.appbrasiliaapi.mappers;

import com.appbrasiliaapi.domain.entities.UserEntity;
import com.appbrasiliaapi.dtos.UserRegisterDto;
import com.appbrasiliaapi.dtos.UserViewDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserEntity convertToEntityFromViewDto(UserViewDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .build()
        ;
    }
    public static UserViewDto convertToDto(UserEntity userEntity) {
        return UserViewDto.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .build()
        ;
    }
    public static List<UserViewDto> convertToListDto(List<UserEntity> users) {
        List<UserViewDto> usersDto = new ArrayList<>();
        users.forEach(user -> usersDto.add(UserViewDto.builder()
                        .id(user.getId())
                        .userName(user.getUserName()).build())
        );
        return usersDto;
    }
    public static UserEntity convertToEntity(UserRegisterDto userDto) {
        return UserEntity.builder().id(0L)
                .userName(userDto.getUserName())
                .build();
    }
}
