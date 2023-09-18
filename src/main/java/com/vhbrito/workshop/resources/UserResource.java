package com.vhbrito.workshop.resources;

import com.vhbrito.workshop.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Mary", "mary@email.com", "999999999", "1234");
        return ResponseEntity.ok().body(user);
    }
}
