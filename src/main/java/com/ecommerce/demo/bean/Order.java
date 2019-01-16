package com.ecommerce.demo.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDERS_SEQ_GEN")
    @SequenceGenerator(name = "ORDERS_SEQ_GEN", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    private int id;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchase_date;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> purchases;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Order() {
        super();
    }

    public Order(Date purchase_date, List<OrderProduct> purchases) {
        super();
        this.purchase_date = purchase_date;
        this.purchases = purchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public List<OrderProduct> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<OrderProduct> purchases) {
        this.purchases = purchases;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", purchase_date=" + purchase_date + ", purchases=" + purchases + "]";
    }



}
