//package com.ecommerce.demo.controller.impl;
//
//
//import com.ecommerce.demo.entity.User;
//import com.ecommerce.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class UserControllerImpl {
//
//    @Autowired @Qualifier("userServices")
//    private UserService userService;
//
//
//
//    //Insert user
//    @RequestMapping("/insert")
//    public String insert() {
//        String row = userService.insertUser();
//
//        return row;
//    }
//
//
//    //ReadAll
//    @RequestMapping("/readall")
//    public String readAll() {
//        List<User> list = userService.readAllUser();
//        List newList = new ArrayList<>();
//
//        for (User user : list) {
//            newList.add(user.getId());
//            newList.add(user.getName());
//            newList.add(user.getAge());
//            newList.add(user.getPassword());
//        }
//        return newList.toString();
//    }
//
//
//}
