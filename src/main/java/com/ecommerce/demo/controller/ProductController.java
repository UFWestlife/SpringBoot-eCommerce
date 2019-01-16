package com.ecommerce.demo.controller;

import com.ecommerce.demo.bean.Product;
import com.ecommerce.demo.dao.ProductDao;
import com.ecommerce.demo.http.Response;
import com.ecommerce.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductDao productDao;

    @Autowired
    ProductService productService;

    @ApiOperation(value = "View All Products as JSON/XML" ,  notes="View All Products and Return as JSON/XML.")
    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Product> getProducts() {
        return productService.getProducts();
    }



    @ApiOperation(value = "View All Products as List" ,  notes="View All Products and Return as List.")
    @GetMapping("/list-products")
    public List<Product> listProducts() {
        return productService.getProducts();
    }


    @ApiOperation(value = "Get a Product by ID" ,  notes="Get a product by ID")
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }


    // TODO: 2019-01-14 GetMapping, output into PDF file



    @ApiOperation(value = "Add a new Product" ,  notes="Add a new product")
    @PostMapping("/products")
    public Response addProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }


    @ApiOperation(value = "Update a product" ,  notes="Update a product")
    @PutMapping("/products")
    public Response updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }



    @ApiOperation(value = "Delete a product by ID" ,  notes="Delete a product by ID")
    @DeleteMapping("/products/{id}")
    public Response deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
