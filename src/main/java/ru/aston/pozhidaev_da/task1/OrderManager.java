package ru.aston.pozhidaev_da.task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class OrderManager {
    private List<AbstractProduct> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(AbstractProduct product) throws CustomOrderException {
        if (product.price <= 0) {
            throw new CustomOrderException(1, "Invalid product price: Price must be bigger than 0.");
        }
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
