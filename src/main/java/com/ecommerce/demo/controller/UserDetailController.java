package com.ecommerce.demo.controller;

import com.ecommerce.demo.bean.UserDetail;
import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.service.UserDetailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-details")
public class UserDetailController {

    @Autowired
    UserDetailService userDetailService;

    @PostMapping
    public Response postUserDetails(@RequestBody UserDetail userDetail, Authentication authentication) {
        return userDetailService.addUserDetail(userDetail, authentication);
    }

    @PutMapping
    public Response putUserDetails(@RequestBody UserDetail userDetail) {
        return userDetailService.updateUserDetail(userDetail);
    }

}
