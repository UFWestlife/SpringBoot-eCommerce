package com.ecommerce.demo.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_PRODUCT_SEQ_GEN")
    @SequenceGenerator(name = "ORDER_PRODUCT_SEQ_GEN", sequenceName = "ORDER_PRODUCT_SEQ", allocationSize = 1)
    private int id;
    @Column
    private int qty;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("purchases")
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderProduct() {
        super();
    }

    public OrderProduct(int qty, Order order, Product product) {
        super();
        this.qty = qty;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProduct [id=" + id + ", qty=" + qty + ", product=" + product + "]";
    }

    @Override
    public boolean equals(Object obj) {
        OrderProduct op =  (OrderProduct)obj;
        return op.getProduct().getId() == product.getId() && op.getOrder().getId() == order.getId();
    }
}


