package com.luongdinh.tinylazada.common.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationTokenFilter extends BasicAuthenticationFilter {

    private TinyLazadaProperties tinyLazadaProperties;

    public AuthorizationTokenFilter(AuthenticationManager authenticationManager,
            TinyLazadaProperties tinyLazadaProperties) {
        super(authenticationManager);
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filter)
            throws IOException, ServletException {

        Optional<UsernamePasswordAuthenticationToken> usernamePasswordAuthenticationToken = getAuthentication(req);
        if (usernamePasswordAuthenticationToken.isPresent()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken.get());
        }
        filter.doFilter(req, res);
    }

    private Optional<UsernamePasswordAuthenticationToken> getAuthentication(HttpServletRequest req) {
        String authenticationHeader = req.getHeader(tinyLazadaProperties.getJwt().getHeader());
        if (StringUtils.isBlank(authenticationHeader))
            return Optional.empty();
        authenticationHeader = authenticationHeader.replace(tinyLazadaProperties.getJwt().getPrefix(),
                StringUtils.EMPTY);
        String userId = Jwts.parser().setSigningKey(tinyLazadaProperties.getJwt().getSecretKey())
                .parseClaimsJws(authenticationHeader).getBody().getSubject();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userId, null);
        return Optional.of(usernamePasswordAuthenticationToken);
    }
}
