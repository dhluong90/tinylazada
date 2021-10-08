package com.luongdinh.identityserver.service;

import java.util.List;

import com.luongdinh.identityserver.domain.User;
import com.luongdinh.identityserver.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
       this.userRepository = userRepository; 
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
}
