package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/users/create")
    @ResponseBody
    public String create(@RequestBody(required = false) User user) {
        return userService.create(user);
    }

    @PostMapping("/users/update-status/{id}+{newStatus}")
    @ResponseBody
    public String updateStatus(@PathVariable("id") Long id,
                               @PathVariable("newStatus") Status newStatus) {
        return userService.updateStatus(id, newStatus);
    }


    @GetMapping("/users/get-all")
    @ResponseBody
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/users/{id}")
    @ResponseBody
    public Optional<User> getUsers(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }


}
