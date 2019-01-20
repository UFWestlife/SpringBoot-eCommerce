package com.ecommerce.demo.controller;

import com.ecommerce.demo.dao.UserDao;
import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "User APIs")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;





    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<User> getUsers(){
        return userDao.findAll();
    }


    @PostMapping
    public Response addUser(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping
    public Response changeUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }






    /****** No Auth Method *******/
/*
    ReadAll
    @ApiOperation(value = "View All User" ,  notes="View All Users and Return as List.")
    @GetMapping
    public String readAll() {
        List list = UserService.readAllUser();
        return list.toString();
    }

    //Register/Insert/Add new user
    // TODO: 2019-01-13 Authentication && Email Service
    @ApiOperation(value = "Register New Customer" ,  notes="Insert a new User into users table.")
    @PostMapping
    public Response addUser(@RequestBody User user) {
        return UserService.register(user);
    }


    //Delete
    @ApiOperation(value = "Delete User" ,  notes="Delete User by user_id")
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) {
        return UserService.deleteUser(id);
    }
    */

}
