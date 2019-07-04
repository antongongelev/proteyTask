package com.application.Controller;

import com.application.Data.DTO.IdAndStatusesDTO;
import com.application.Data.Enum.Status;
import com.application.Data.User;
import com.application.Exception.BadRequestException;
import com.application.Service.UserService;
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
    public Long create(@RequestBody(required = false) User user) throws BadRequestException {
        return userService.create(user);
    }

    @PostMapping("update-status/{id}+{newStatus}")
    public IdAndStatusesDTO updateStatus(@PathVariable("id") Long id,
                                         @PathVariable("newStatus") Status newStatus) throws BadRequestException {
        return userService.updateStatus(id, newStatus);
    }

    @GetMapping("get-all")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "{id}")
    public User getUsers(@PathVariable("id") Long id) throws BadRequestException {
        return userService.getUser(id);
    }

}
