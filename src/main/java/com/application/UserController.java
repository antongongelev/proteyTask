package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public Long create(@RequestBody(required = false) User user) {
        return userService.create(user);
    }

    @PostMapping("update-status/{id}+{newStatus}")
    public IdAndStatusesDTO updateStatus(@PathVariable("id") Long id,
                                         @PathVariable("newStatus") Status newStatus) throws Exception {
        return userService.updateStatus(id, newStatus);
    }

    @GetMapping("get-all")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "{id}")
    public User getUsers(@PathVariable("id") Long id) throws Exception {
        return userService.getUser(id);
    }

}
