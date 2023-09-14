package ru.aston.pozhidaev_da.task1;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OrderDaoTest {
    @Mock
    private OrderDao orderDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Определение поведения мока для метода findAll()
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Order Details 1"));
        when(orderDao.findAll()).thenReturn(orders);

        // Определение поведения мока для метода findEntityById()
        int orderId = 1;
        Order order = new Order(orderId, "Order Details 1");
        when(orderDao.findEntityById(orderId)).thenReturn(order);
    }

    @Test
    public void testFindAll() {
        List<Order> orders = orderDao.findAll();
        assertEquals(1, orders.size());
    }

    @Test
    public void testFindEntityById() {
        int orderId = 1;
        Order order = orderDao.findEntityById(orderId);
        assertEquals(orderId, order.getId());
    }
}
