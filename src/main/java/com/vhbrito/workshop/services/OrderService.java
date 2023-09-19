package com.vhbrito.workshop.services;

import com.vhbrito.workshop.entities.Order;
import com.vhbrito.workshop.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
