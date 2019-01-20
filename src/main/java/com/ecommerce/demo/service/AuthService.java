package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.UserDao;
import com.ecommerce.demo.http.AuthenticationSuccessResponse;
import com.ecommerce.demo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserDao userDao;

    public Response checklogin(Authentication authentication) {
        if (authentication != null) {
            Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
            return response;
        } else {
            return new Response(false);
        }
    }
}
