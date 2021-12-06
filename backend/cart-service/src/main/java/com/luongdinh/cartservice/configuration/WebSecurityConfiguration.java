package com.luongdinh.cartservice.configuration;

import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;
import com.luongdinh.tinylazada.common.security.AuthorizationTokenFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    TinyLazadaProperties tinyLazadaProperties;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/swagger-ui").permitAll().and()
                .authorizeRequests().antMatchers("/carts").authenticated().and()
                .addFilter(getAuthorizationFilter());
        http.headers().frameOptions().disable();
    }

    private AuthorizationTokenFilter getAuthorizationFilter() throws Exception {
        return new AuthorizationTokenFilter(authenticationManager(), tinyLazadaProperties);
    }
}
