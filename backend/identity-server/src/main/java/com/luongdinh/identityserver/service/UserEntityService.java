package com.luongdinh.identityserver.service;

import java.util.Optional;

import com.luongdinh.identityserver.domain.UserEntity;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.repository.UserRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface UserEntityService extends CRUDService<UserEntity, Long, UserRepository> {

    /**
     * Register new user by email
     * 
     * @param userRequestDto
     * @return
     */
    UserEntity signUpByEmail(UserRequestDto userRequestDto);

    /**
     * Get User Entity by email
     * 
     * @return
     */
    Optional<UserEntity> getUserByEmail(String email);

}
