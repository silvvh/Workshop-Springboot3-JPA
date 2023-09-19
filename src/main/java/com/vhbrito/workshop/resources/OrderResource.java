package com.vhbrito.workshop.resources;

import com.vhbrito.workshop.entities.Order;
import com.vhbrito.workshop.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

}
