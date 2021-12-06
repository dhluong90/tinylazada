package com.luongdinh.identityserver.mapper;

import com.luongdinh.identityserver.domain.UserEntity;
import com.luongdinh.identityserver.dto.UserResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponseDto UserToUserResponseDto(UserEntity userEntity);
}
