package com.ecommerce.demo.dao;

import com.ecommerce.demo.bean.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailDao extends JpaRepository<UserDetail, Integer> {

}
