package com.ecommerce.demo.dao;

import com.ecommerce.demo.bean.Product;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    public List<Product> findByBrand(String brand);

    @Query("select max(p.price) from Product p")
    public int getMaxPrice();

    @Query("select p from Product p where p.stock > :stock")
    public List<Product> getProducstWithStock(@Param("stock") int stock);

    @Override
    @CachePut(value = "products", key = "#result.id")
    Product save(Product p);
}
