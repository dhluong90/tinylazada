package com.luongdinh.identityserver.service;

import com.luongdinh.identityserver.domain.User;
import com.luongdinh.identityserver.dto.UserRequestDto;

public interface AuthenticationService {

    User signUpByEmail(UserRequestDto userRequestDto); 
    boolean loginByEmail(); 
}
