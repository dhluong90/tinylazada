package com.luongdinh.identityserver.configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

public class UsernamePasswordAuthenticationFilter extends AuthenticationFilter {

    public UsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager,
            AuthenticationConverter authenticationConverter) {
        super(authenticationManager, authenticationConverter);
    }

}
