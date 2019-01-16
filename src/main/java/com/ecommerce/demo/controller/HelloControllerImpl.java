package com.ecommerce.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class HelloControllerImpl {

    @RequestMapping("/")
    public String helloHtml(HashMap<String, Object> map) {
//        map.put("hello", "Welcome to html page");
        return "/index";
    }
}
