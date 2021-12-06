package com.luongdinh.identityserver.configuration;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luongdinh.identityserver.domain.UserEntity;
import com.luongdinh.identityserver.dto.LoginRequestDto;
import com.luongdinh.identityserver.service.UserEntityService;
import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;
import com.luongdinh.tinylazada.common.exceptions.UnknowExcpetion;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    UserEntityService userDetailsService;
    TinyLazadaProperties tinyLazadaProperties;

    public AuthenticationFilter(AuthenticationManager authenticationManager, UserEntityService userDetailsService,
            TinyLazadaProperties tinyLazadaProperties) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        try {
            LoginRequestDto loginRequestDto = new ObjectMapper().readValue(request.getInputStream(),
                    LoginRequestDto.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getEmail(), loginRequestDto.getPassword());
            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain,
            Authentication auth) {
        String userName = ((User) auth.getPrincipal()).getUsername();
        UserEntity userEntity = userDetailsService.getUserByEmail(userName).orElseThrow(UnknowExcpetion::new);
        String token = Jwts.builder().setSubject(userEntity.getId().toString())
                .setExpiration(new Date(
                        System.currentTimeMillis() + tinyLazadaProperties.getJwt().getExpiredInSecond() * 1000))
                .claim(tinyLazadaProperties.getJwt().getClaim().getUserName(), userName)
                .signWith(SignatureAlgorithm.HS512, tinyLazadaProperties.getJwt().getSecretKey()).compact();
        res.setHeader("token", token);
        res.setHeader("userName", userName);
    };

}
