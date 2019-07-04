package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Long create(User user) throws BadRequestException {

        for (User u : userRepo.findAll()) {
            if (user.getEmail().equals(u.getEmail())) {
                throw new BadRequestException
                        ("The email \'" + user.getEmail() + "\' has already been registered");
            }
        }
        userRepo.save(user);
        return user.getId();
    }

    public IdAndStatusesDTO updateStatus(Long id, Status newStatus) throws BadRequestException {

        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new BadRequestException("User with id \'" + id + "\' was not found");
        }
        if (newStatus != Status.ONLINE && newStatus != Status.OFFLINE && newStatus != Status.AWAY) {
            throw new BadRequestException("New Status should be 'ONLINE', 'OFFLINE' or 'AWAY'");
        }
        Status previousStatus = user.getStatus();
        user.setStatus(newStatus);
        userRepo.save(user);
        return new IdAndStatusesDTO(id, previousStatus, newStatus);
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) throws BadRequestException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new BadRequestException("User with id \'" + id + "\' was not found");
        }
        return user;
    }
}
