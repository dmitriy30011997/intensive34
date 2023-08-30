package ru.aston.pozhidaev_da.task1;

public class PrescriptionProduct extends AbstractProduct {
    public PrescriptionProduct(String name, double price, User user) {
        super(name, price, user);
    }

    @Override
    public double calculateDiscount() {
        return price - (price/8);
    }
}
