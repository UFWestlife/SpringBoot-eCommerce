package com.ecommerce.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    @Autowired
    UserDetailsService userDetailsService;




}
