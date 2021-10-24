package com.luongdinh.identityserver.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.luongdinh.identityserver.domain.User;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {


    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    AuthenticationService authenticationService;
    ModelMapper modelMapper;

    
    @BeforeEach
    void preTest(){ 
        authenticationService = new AuthenticationServiceImpl(userRepository);
        modelMapper = new ModelMapper();
    }

    @Test
    public void signUpByEmail() {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setEmail("userTest@gmail.com");
        userRequestDto.setFirstName("user");
        userRequestDto.setLastName("test");
        userRequestDto.setPassword("12345");;
        authenticationService.signUpByEmail(userRequestDto);
        String enryptedPassword = "12345-enrypted";
        User user = this.modelMapper.map(userRequestDto, User.class);
        user.setEnryptedPassword(enryptedPassword);
        user.setId(1L);
        when(userRepository.save(any(User.class))).thenReturn(user); 
        when(bCryptPasswordEncoder.encode(userRequestDto.getPassword())).thenReturn(enryptedPassword);
        User userResult = authenticationService.signUpByEmail(userRequestDto);
        assertEquals(userResult.getId() , user.getId());
        assertEquals(userResult.getEnryptedPassword() , user.getEnryptedPassword());
    }

}
