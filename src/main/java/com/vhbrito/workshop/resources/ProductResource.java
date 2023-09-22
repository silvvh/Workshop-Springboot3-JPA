package com.vhbrito.workshop.resources;

import com.vhbrito.workshop.entities.Product;
import com.vhbrito.workshop.services.ProductService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
