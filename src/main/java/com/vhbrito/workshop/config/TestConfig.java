package com.vhbrito.workshop.config;

import com.vhbrito.workshop.entities.*;
import com.vhbrito.workshop.entities.enums.OrderStatus;
import com.vhbrito.workshop.repositories.*;
import org.hibernate.id.IdentifierGenerationException;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Order o1 = new Order(null, Instant.now(), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2023-09-19T15:30:15Z"), u1, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.now(), u2, OrderStatus.CANCELED);
        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        p1.getCategories().add(c2);
        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
        p3.getCategories().add(c1);
        p4.getCategories().add(c1);
        p5.getCategories().add(c2);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
        Payment pay1 = new Payment(null, Instant.parse("2023-09-19T15:30:15Z"), o1);
        Payment pay2 = new Payment(null, Instant.parse("2023-10-20T21:30:48Z"), o2);
        Payment pay3 = new Payment(null, Instant.parse("2023-05-12T10:20:37Z"), o3);
            o1.setPayment(pay1);
            o2.setPayment(pay2);
            o3.setPayment(pay3);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
