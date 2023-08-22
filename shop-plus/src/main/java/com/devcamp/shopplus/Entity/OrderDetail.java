package com.devcamp.shopplus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity_order")
    private int quantityOrder;
    @Column(name = "price_each")
    private double priceEach;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double peiceEach) {
        this.priceEach = peiceEach;
    }

    // public Order getOrder() {
    // return order;
    // }

    public void setOrder(Order order) {
        this.order = order;
    }

    // public Product getProduct() {
    // return product;
    // }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail(long id, int quantityOrder, double priceEach, Order order, Product product) {
        this.id = id;
        this.quantityOrder = quantityOrder;
        this.priceEach = priceEach;
        this.order = order;
        this.product = product;
    }

    public OrderDetail() {
    }

}
