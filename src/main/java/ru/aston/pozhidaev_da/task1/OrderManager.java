package ru.aston.pozhidaev_da.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderManager {
    private List<AbstractProduct> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(AbstractProduct product) {
        orders.add(product);
    }
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (AbstractProduct product : orders) {
            totalPrice += product.price;
        }
        return totalPrice;
    }

    public void sortOrdersByUserSurname() {
        orders.sort(Comparator.comparing(p -> p.user.getSurname()));
    }
}
