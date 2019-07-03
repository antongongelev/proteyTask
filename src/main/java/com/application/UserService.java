package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String create(User user) {
        userRepo.save(user);
        return "Unique id of created user: " + user.getId();
    }

    public String updateStatus(Long id, Status newStatus) {
        User user = userRepo.findById(id).get();
        Status previousStatus = user.getStatus();
        user.setStatus(newStatus);
        userRepo.save(user);
        return "Status of user with id " + id +
                " has been changed from " + previousStatus + " to " + newStatus;
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }
}
