package com.luongdinh.identityserver.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRequestDto {
    
    @NotBlank(message="Email cannot be blank")
    private String email;
    @NotBlank(message="firstName cannot be blank")
    private String firstName;
    @NotBlank(message="lastName cannot be blank")
    private String lastName;
    @NotBlank(message="password cannot be blank")
    private String password;
}
