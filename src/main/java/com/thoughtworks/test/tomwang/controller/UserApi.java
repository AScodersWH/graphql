package com.thoughtworks.test.controller;

import com.thoughtworks.test.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping
    public void register(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getOneById(@PathVariable Integer userId) {
        return userService.findOneById(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteOneById(@PathVariable Integer userId) {
        return userService.deleteOneById(userId);
    }


}
