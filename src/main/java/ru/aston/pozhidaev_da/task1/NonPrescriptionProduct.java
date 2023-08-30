package ru.aston.pozhidaev_da.task1;

public class NonPrescriptionProduct extends AbstractProduct {
    public NonPrescriptionProduct(String name, double price, User user) {
        super(name, price, user);
    }
    @Override
    public double calculateDiscount() {
        return price - (price/11);
    }
}
