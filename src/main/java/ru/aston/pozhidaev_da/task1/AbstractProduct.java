package ru.aston.pozhidaev_da.task1;

public abstract class AbstractProduct {
    protected String name;
    protected double price;
    protected User user;

    public AbstractProduct(String name, double price, User user) {
        this.name = name;
        this.price = price;
        this.user = user;
    }

    public abstract double calculateDiscount();
}

