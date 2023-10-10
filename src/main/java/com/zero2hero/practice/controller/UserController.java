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

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegister(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.login(userDTO.getOwnerEmail(),userDTO.getPassword()), HttpStatus.OK);
    }
}
