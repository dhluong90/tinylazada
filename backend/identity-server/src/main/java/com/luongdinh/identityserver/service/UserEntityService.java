package com.luongdinh.identityserver.service;

import com.luongdinh.identityserver.domain.UserEntity;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.repository.UserRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface UserEntityService extends CRUDService<UserEntity, Long, UserRepository> {

    UserEntity signUpByEmail(UserRequestDto userRequestDto);
}
