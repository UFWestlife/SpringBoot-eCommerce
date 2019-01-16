package com.ecommerce.demo.dao;

import com.ecommerce.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
