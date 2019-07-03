package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Long create(User user) {
        userRepo.save(user);
        return user.getId();
    }

    public IdAndStatusesDTO updateStatus(Long id, Status newStatus) throws Exception {

        User user = userRepo.findById(id).orElse(null);
        if (user == null)
            throw new Exception("User was not found");//Could use logger, but it would have taken more time
        if (!newStatus.name().toUpperCase().equals("ONLINE")&&
                !newStatus.name().toUpperCase().equals("OFFLINE")&&
                !newStatus.name().toUpperCase().equals("AWAY")){
            throw new Exception("Status should be 'ONLINE', 'OFFLINE' or 'AWAY'");
        }//TODO
        Status previousStatus = user.getStatus();
        user.setStatus(newStatus);
        userRepo.save(user);
        return new IdAndStatusesDTO(id, previousStatus, newStatus);
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) throws Exception {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) throw new Exception("User was not found");
        return user;
    }
}
