package com.vhbrito.workshop.resources;


import com.vhbrito.workshop.entities.OrderItem;
import com.vhbrito.workshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class OrderItemResource {
    @Autowired
    OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        return ResponseEntity.ok().body(orderItemService.findAll());
    }
}
