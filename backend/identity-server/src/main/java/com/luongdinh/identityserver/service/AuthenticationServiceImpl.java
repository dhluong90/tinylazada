package com.luongdinh.identityserver.service;

import com.luongdinh.identityserver.domain.User;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationServiceImpl(UserRepository userRepositiory) {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepositiory;
    }

    @Override
    public User signUpByEmail(UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userRequestDto, User.class);
        user.setEnryptedPassword(this.bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean loginByEmail() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
