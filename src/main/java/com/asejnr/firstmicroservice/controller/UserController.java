package com.asejnr.firstmicroservice.controller;

import com.asejnr.firstmicroservice.model.User;
import com.asejnr.firstmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/add-user")
   public User createUser(@RequestBody User user) {
        return userService.save(user);
   }

   @GetMapping("/users/{id}")
   public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
   }

   @PutMapping("/users/{id}")
   public User updateUser(@PathVariable Long id, @RequestBody User user) {
             return userService.update(user);
   }

   @DeleteMapping("/users/{id}")
   public void deleteUserById(@PathVariable Long id) {
        userService.delete(id);
   }
}
