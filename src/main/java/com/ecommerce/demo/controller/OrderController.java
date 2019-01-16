package com.ecommerce.demo.controller;


import com.ecommerce.demo.bean.Order;
import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.dao.OrderDao;
import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Api(description = "Order APIs")
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> getOrders(int user_id) {
        System.out.println("Fetching order list of user_id="+ user_id);
        return orderService.getOrders(user_id);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderDao.findById(id).get();
    }


    public void printOrders() {
        System.out.println(Arrays.asList((List<Order>) orderDao.findAll()));
    }

    @PostMapping("/orders")
    public Response postOrders(@RequestBody Order order, User user) {
        return orderService.addOrder(order, user);
    }
}
