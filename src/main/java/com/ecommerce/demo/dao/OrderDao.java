package com.ecommerce.demo.dao;

import com.ecommerce.demo.bean.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<Order, Integer> {

    public List<Order> findByUserId(int id);
}
