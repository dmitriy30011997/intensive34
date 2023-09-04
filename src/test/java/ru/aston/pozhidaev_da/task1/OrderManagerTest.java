package ru.aston.pozhidaev_da.task1;

import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.util.ArrayList;

public class OrderManagerTest {
    private OrderManager orderManager;

    @Before
    public void setUp() {
        orderManager = new OrderManager();
    }
    @Test
    public void testAddOrderWithInvalidPrice() {
        try {
            // Попытка добавить продукт с недопустимой ценой (<= 0)
            AbstractProduct product = new NonPrescriptionProduct("Product 1", -10.0, new User(20, "John", "Doe"));
            orderManager.addOrder(product);
            Assert.fail("Expected CustomOrderException to be thrown");
        } catch (CustomOrderException e) {
            Assert.assertEquals(1, e.getErrorCode());
            Assert.assertEquals("Invalid product price: Price must be greater than 0.", e.getErrorMessage());
        }
    }

    @Test
    public void testApplyDiscountWithInvalidDiscount() {
        try {
            // Попытка применить скидку, которая делает цену отрицательной
            AbstractProduct product = new NonPrescriptionProduct("Product 2", 5.0, new User(25, "Alice", "Smith"));
            double discount = 10.0;
            orderManager.applyDiscount(product, discount);
            Assert.fail("Expected CustomOrderException to be thrown");
        } catch (CustomOrderException e) {
            Assert.assertEquals(2, e.getErrorCode());
            Assert.assertEquals("Invalid discount: Discounted price cannot be zero or negative.", e.getErrorMessage());
        }
    }
    @Test
    public void testAddOrder() {
        AbstractProduct product = new NonPrescriptionProduct("Product 1", 10.0, new User(20, "John", "Doe"));
        orderManager.addOrder(product);
    }

    @Test
    public void testCalculateTotalPrice() {
        AbstractProduct product1 = new NonPrescriptionProduct("Product 1", 10.0, new User(20, "John", "Doe"));
        AbstractProduct product2 = new PrescriptionProduct("Product 2", 20.0, new User(30, "Jane", "Doe"));
        orderManager.addOrder(product1);
        orderManager.addOrder(product2);
        Assert.assertEquals(30.0, orderManager.calculateTotalPrice(), 0.001);
    }

    @Test
    public void testSortOrdersByUserSurname() {
        AbstractProduct product1 = new NonPrescriptionProduct("Product 1", 10.0, new User(20, "John", "Doe"));
        AbstractProduct product2 = new PrescriptionProduct("Product 2", 20.0, new User(30, "Jane", "Doe"));
        AbstractProduct product3 = new NonPrescriptionProduct("Product 3", 30.0, new User(25, "Bob", "Smith"));
        orderManager.addOrder(product1);
        orderManager.addOrder(product2);
        orderManager.addOrder(product3);
        orderManager.sortOrdersByUserSurname();
        List<AbstractProduct> expected = new ArrayList<>();
        expected.add(product2);
        expected.add(product1);
        expected.add(product3);
        Assert.assertEquals(expected, orderManager.getOrders());
    }
}