package com.appbrasiliaapi.services.impls;

import com.appbrasiliaapi.domain.entities.UserEntity;
import com.appbrasiliaapi.domain.repositories.UserRepository;
import com.appbrasiliaapi.dtos.UserRegisterDto;
import com.appbrasiliaapi.dtos.UserViewDto;
import com.appbrasiliaapi.mappers.UserMapper;
import com.appbrasiliaapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserViewDto getById(Long id) {
        Optional<UserEntity> optional = userRepository.findById(id);
        return optional.map(UserMapper::convertToDto).orElse(null);
    }

    @Override
    public List<UserViewDto> getAll(){
        return UserMapper.convertToListDto(userRepository.findAll());
    }

    @Override
    public Long register(UserRegisterDto user) {
        return userRepository.save(UserMapper.convertToEntity(user)).getId();
    }
}
