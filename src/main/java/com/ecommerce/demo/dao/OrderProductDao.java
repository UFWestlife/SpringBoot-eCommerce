package com.ecommerce.demo.dao;

import com.ecommerce.demo.bean.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderProductDao extends JpaRepository<OrderProduct, Integer>{

}