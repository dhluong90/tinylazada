package com.luongdinh.identityserver.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.luongdinh.identityserver.domain.User;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.service.AuthenticationService;
import com.luongdinh.identityserver.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {


    AuthenticationService authenticationService;
    UserService userService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity singup(@RequestBody @Validated UserRequestDto  userRequestDto) {
        authenticationService.signUpByEmail(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUser(); 
        return ResponseEntity.ok().body(users);
    }
    
}
