package com.zero2hero.practice.service.impl;

import com.zero2hero.practice.convertor.UserConverter;
import com.zero2hero.practice.dto.UserDTO;
import com.zero2hero.practice.entity.UserEntity;
import com.zero2hero.practice.exception.BusinessException;
import com.zero2hero.practice.exception.ErrorModel;
import com.zero2hero.practice.repository.UserRepository;
import com.zero2hero.practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> existingUserByEmail = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(existingUserByEmail.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ALREADY_EXIST");
            errorModel.setMessage("This email already exist!!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }else{
            UserEntity userEntity = userConverter.convertUserDTOtoUserEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConverter.convertUserEntitytoUserDTO(userEntity);
            return userDTO;
        }
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity>userEntity = userRepository.findByOwnerEmailAndPassword(email,password);
        if(userEntity.isPresent()){
            return userConverter.convertUserEntitytoUserDTO(userEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect username and password!!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
    }
}
