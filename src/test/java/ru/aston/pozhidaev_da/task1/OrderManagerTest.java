package ru.aston.pozhidaev_da.task1;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

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

    @Test
    public void testArrayListConstructor() {
        // Тестирование конструкторов ArrayList
        List<String> list1 = new ArrayList<>(); // Конструктор по умолчанию
        List<String> list2 = new ArrayList<>(10); // Конструктор с начальной емкостью

        assertNotNull(list1);
        assertNotNull(list2);
    }

    @Test
    public void testHashMapConstructor() {
        // Тестирование конструкторов HashMap
        Map<String, Integer> map1 = new HashMap<>(); // Конструктор по умолчанию
        Map<String, Integer> map2 = new HashMap<>(10); // Конструктор с начальной емкостью

        assertNotNull(map1);
        assertNotNull(map2);
    }

    @Test
    public void testTreeSetConstructor() {
        // Тестирование конструктора TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        assertNotNull(set);
    }

    @Test
    public void testArrayListMethods() {
        // Тестирование основных методов ArrayList
        List<String> list = new ArrayList<>();

        // Добавление элементов
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Проверка размера
        assertEquals(3, list.size());

        // Получение элемента по индексу
        assertEquals("Item 1", list.get(0));

        // Проверка наличия элемента
        assertTrue(list.contains("Item 2"));

        // Удаление элемента
        list.remove("Item 2");
        assertFalse(list.contains("Item 2"));
    }

    @Test
    public void testHashMapMethods() {
        // Тестирование основных методов HashMap
        Map<String, Integer> map = new HashMap<>();

        // Добавление элементов
        map.put("Key 1", 1);
        map.put("Key 2", 2);
        map.put("Key 3", 3);

        // Проверка размера
        assertEquals(3, map.size());

        // Получение значения по ключу
        assertEquals(Integer.valueOf(2), map.get("Key 2"));

        // Проверка наличия ключа
        assertTrue(map.containsKey("Key 3"));

        // Удаление элемента по ключу
        map.remove("Key 2");
        assertFalse(map.containsKey("Key 2"));
    }

    @Test
    public void testTreeSetMethods() {
        // Тестирование основных методов TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        // Добавление элементов
        set.add(3);
        set.add(1);
        set.add(2);

        // Проверка размера
        assertEquals(3, set.size());

        // Проверка наличия элемента
        assertTrue(set.contains(2));

        // Удаление элемента
        set.remove(2);
        assertFalse(set.contains(2));
    }
}
