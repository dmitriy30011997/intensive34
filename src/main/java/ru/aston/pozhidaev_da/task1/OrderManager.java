package ru.aston.pozhidaev_da.task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class OrderManager {
    private List<AbstractProduct> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order, OrderType orderType) {
        order.setOrderType(orderType);
        orders.add(order);
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

    public List<Order> getOrder(OrderType orderType) {
        List<Order> result = new ArrayList<>();
        for (AbstractProduct order : orders) {
            if (order.getOrderType() == orderType) {
                result.add(order);
            }
        }
        return result;
    }

    public List<AbstractProduct> getOrders() {
        return this.orders;
    }
}
