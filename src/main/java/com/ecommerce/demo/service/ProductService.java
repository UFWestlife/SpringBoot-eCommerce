package com.ecommerce.demo.service;


import com.ecommerce.demo.bean.Product;
import com.ecommerce.demo.dao.ProductDao;
import com.ecommerce.demo.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.List;

@Service
public class ProductService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ServletContext context;

    @Autowired
    ProductDao productDao;

    // add products list into cache
    @Cacheable("productsList")
    public List<Product> getProducts() {
        return productDao.findAll();
    }


    // remove products list from cache for updating.
    @CacheEvict(value = "productsList", allEntries = true)
    public Response saveProduct(Product product) {
        try {
            productDao.save(product);
            return new Response(true, product.toString()+" inserted Successfully!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new Response(false, e.getMessage());
        }
    }




    // add retrieved product into cache.
    @Cacheable(value = "products", key = "#id")
    public Product getProduct(int id) {
        return productDao.findById(id).get();
    }

    // cache moved to dao for updating purpose
    public Response updateProduct(Product product) {
        try {
            Product p = productDao.getOne(product.getId());
            p.setName(product.getName());
            p.setBrand(product.getBrand());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            p.setImage(product.getImage());
            productDao.save(p);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }

    // remove from cache.
    @CacheEvict(value = "products", key = "#id")
    public Response deleteProduct(int id) {
        try {
            productDao.deleteById(id);
            return new Response(true, "Successfully deleted product with id="+id);
        } catch (Exception e) {
            return new Response(false, e.getMessage());
        }
    }
}
