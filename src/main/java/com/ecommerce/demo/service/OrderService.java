package com.ecommerce.demo.service;


import com.ecommerce.demo.bean.Order;
import com.ecommerce.demo.bean.OrderProduct;
import com.ecommerce.demo.bean.Product;
import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.dao.OrderDao;
import com.ecommerce.demo.dao.OrderProductDao;
import com.ecommerce.demo.dao.ProductDao;
import com.ecommerce.demo.dao.UserDao;
import com.ecommerce.demo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    OrderProductDao orderProductDao;

    @Autowired
    UserDao userDao;

    public Response addOrder(Order order, User user) {
        try {
            List<OrderProduct> purchases = order.getPurchases();
            for (OrderProduct orderProduct: purchases) {
                Product product = productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                orderProduct.setOrder(order);
            }

            order.setUser(userDao.findByUsername(user.getUsername()));
            order.setPurchases(null);
            orderDao.save(order);
            for (OrderProduct orderProduct : purchases) {
                orderProductDao.save(orderProduct);
            }

            order.setPurchases(purchases);
            // TODO: 2019-01-16 Generate OrderMsg

            return new Response(true, "Order added successfully!");
        } catch (Exception e) {
            return new Response(false, e.getMessage());
        }
    }


    public void deleteOrderProducts(List<OrderProduct> purchases) {
        orderProductDao.deleteAll(purchases);
    }

    public List<Order> getOrders(int user_id) {
        // TODO: 2019-01-16 Authentication passed in
        return (List<Order>)orderDao.findByUserId(user_id);
    }



}

