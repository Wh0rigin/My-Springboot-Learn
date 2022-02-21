package com.who.springboot.controller;

import com.who.springboot.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User user;
    @GetMapping("/name")
    public String name(){
        return user.getName();
    }
    @GetMapping("/password")
    public String password(){
        return user.getPassword();
    }
}
