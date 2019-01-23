package com.ecommerce.demo.controller;

import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/checklogin")
    public Response checklogin(Authentication authentication) {
        return authService.checklogin(authentication);
    }
}
