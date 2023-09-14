package ru.aston.pozhidaev_da.task1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testcontainers.containers.GenericContainer;

public class RedisContainerInitializer {
    private static final int REDIS_PORT = 6379;

    // Запуск контейнера Redis перед всеми тестами
    public static GenericContainer<?> redisContainer = new GenericContainer<>("redis:latest")
            .withExposedPorts(REDIS_PORT);

    @BeforeClass
    public static void startRedisContainer() {
        redisContainer.start();
        System.setProperty("spring.redis.host", redisContainer.getContainerIpAddress());
        System.setProperty("spring.redis.port", String.valueOf(redisContainer.getFirstMappedPort()));
    }

    @AfterClass
    public static void stopRedisContainer() {
        redisContainer.stop();
    }
}
