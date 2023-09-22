package com.vhbrito.workshop.services;

import com.vhbrito.workshop.entities.User;
import com.vhbrito.workshop.repositories.UserRepository;
import com.vhbrito.workshop.services.exceptions.DatabaseException;
import com.vhbrito.workshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        try {
            if (userRepository.existsById(id)) userRepository.deleteById(id);
            else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
}

    public User updateUser(Long id, User user) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
    }
}
