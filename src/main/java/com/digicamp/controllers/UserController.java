package com.digicamp.controllers;

import com.digicamp.entity.User;
import com.digicamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User u = userService.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

}
