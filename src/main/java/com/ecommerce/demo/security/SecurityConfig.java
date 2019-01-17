package com.ecommerce.demo.security;


import com.ecommerce.demo.bean.UserDetail;
import com.ecommerce.demo.security.handler.*;
import com.ecommerce.demo.service.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPointImpl;

    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    @Autowired
    AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    @Autowired
    AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Autowired
    LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Autowired
    UserDetailService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder(11);
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    }
