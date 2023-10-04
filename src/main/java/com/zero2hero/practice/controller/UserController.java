package com.zero2hero.practice.controller;

import com.zero2hero.practice.dto.UserDTO;
import com.zero2hero.practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegister(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
    }
}
