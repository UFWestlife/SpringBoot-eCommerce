package com.ecommerce.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.bean.UserDetail;
import com.ecommerce.demo.dao.UserDao;
import com.ecommerce.demo.dao.UserDetailDao;
import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.http.UserDetailResponse;

import java.util.ArrayList;


@Service
public class UserDetailService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserDetailDao userDetailDao;

    public Response addUserDetail(UserDetail userDetail, Authentication authentication) {
        User user = userDao.findByUsername(authentication.getName());
        userDetail.setUser(user);
        return new UserDetailResponse(true, userDetailDao.save(userDetail));
    }

    public Response updateUserDetail(UserDetail userDetail) {
        UserDetail ud = userDetailDao.findById(userDetail.getId()).get();
        userDetail.setUser(ud.getUser());
        ud = userDetail;
        userDetailDao.save(ud);
        return new Response(true);
    }


}
