package com.vhbrito.workshop.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import com.vhbrito.workshop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
