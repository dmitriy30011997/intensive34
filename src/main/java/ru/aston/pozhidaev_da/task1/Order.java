package ru.aston.pozhidaev_da.task1;

import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private int id;
    private LocalDateTime date;
    private List<AbstractProduct> products;
    private OrderType orderType;

    public Order(int id, LocalDateTime date, List<AbstractProduct> products, OrderType orderType) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.orderType = orderType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<AbstractProduct> getProducts() {
        return this.products;
    }

    public void setProducts(List<AbstractProduct> products) {
        this.products = products;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}
