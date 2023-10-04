package com.zero2hero.practice.service.impl;

import com.zero2hero.practice.convertor.UserConverter;
import com.zero2hero.practice.dto.UserDTO;
import com.zero2hero.practice.entity.UserEntity;
import com.zero2hero.practice.repository.UserRepository;
import com.zero2hero.practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertUserDTOtoUserEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertUserEntitytoUserDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
