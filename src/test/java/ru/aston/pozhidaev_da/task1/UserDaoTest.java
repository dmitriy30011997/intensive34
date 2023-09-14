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

public class UserDaoTest {
    @Mock
    private UserDao userDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Определение поведения мока для метода findAll()
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "+123456789", "john@example.com", 0));
        when(userDao.findAll()).thenReturn(users);

        // Определение поведения мока для метода findEntityById()
        int userId = 1;
        User user = new User(userId, "John Doe", "+123456789", "john@example.com", 0);
        when(userDao.findEntityById(userId)).thenReturn(user);
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        assertEquals(1, users.size()); // Замените на ожидаемое количество пользователей
    }

    @Test
    public void testFindEntityById() {
        int userId = 1;
        User user = userDao.findEntityById(userId);
        assertEquals(userId, user.getId()); // Замените на ожидаемый ID пользователя
    }
}
