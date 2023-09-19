package com.vhbrito.workshop.repositories;

import com.vhbrito.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
