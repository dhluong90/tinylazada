package com.luongdinh.identityserver.configuration;

import com.luongdinh.identityserver.service.UserEntityService;
import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;
import com.luongdinh.tinylazada.common.security.AuthorizationTokenFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private UserEntityService userEntityService;
    private TinyLazadaProperties tinyLazadaProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/swagger-ui").permitAll().and().authorizeRequests()
                .antMatchers("/users/**").authenticated().and().addFilter(getAuthenticationFiler())
                .addFilter(getAuthorizationFilter());
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    private AuthenticationFilter getAuthenticationFiler() throws Exception {
        return new AuthenticationFilter(authenticationManager(), userEntityService, tinyLazadaProperties);
    }

    private AuthorizationTokenFilter getAuthorizationFilter() throws Exception {
        return new AuthorizationTokenFilter(authenticationManager(), tinyLazadaProperties);
    }

}
