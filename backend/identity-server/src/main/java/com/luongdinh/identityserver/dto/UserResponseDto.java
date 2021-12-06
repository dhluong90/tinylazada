package com.luongdinh.identityserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private String email;
    private String firstName;
    private String lastName;
    private Long id;
}
