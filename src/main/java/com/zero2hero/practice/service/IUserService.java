package com.zero2hero.practice.service;

import com.zero2hero.practice.dto.UserDTO;

public interface IUserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password);
}
