package com.vhbrito.workshop.config;

import com.vhbrito.workshop.entities.Order;
import com.vhbrito.workshop.entities.User;
import com.vhbrito.workshop.entities.enums.OrderStatus;
import com.vhbrito.workshop.repositories.OrderRepository;
import com.vhbrito.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Order o1 = new Order(null, Instant.now(), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2023-09-19T15:30:15Z"), u1, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.now(), u2, OrderStatus.CANCELED);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
