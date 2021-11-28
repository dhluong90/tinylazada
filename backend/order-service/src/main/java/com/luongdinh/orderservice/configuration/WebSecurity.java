package com.luongdinh.orderservice.configuration;

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
    private TinyLazadaProperties tinyLazadaProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll().and().addFilter(getAuthorizationFilter());
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    private AuthorizationTokenFilter getAuthorizationFilter() throws Exception {
        return new AuthorizationTokenFilter(authenticationManager(), tinyLazadaProperties);
    }

}
