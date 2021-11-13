package com.luongdinh.identityserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.dto.UserResponseDto;
import com.luongdinh.identityserver.mapper.UserMapper;
import com.luongdinh.identityserver.service.UserEntityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users/")
public class UserController {

    UserEntityService userEntityService;
    UserMapper userMapper;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> singup(@RequestBody @Validated UserRequestDto userRequestDto) {
        userEntityService.signUpByEmail(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = new ArrayList<UserResponseDto>();
        this.userEntityService.getAll().forEach(i -> {
            users.add(userMapper.UserToUserResponseDto(i));
        });
        return ResponseEntity.ok().body(users);
    }

}
