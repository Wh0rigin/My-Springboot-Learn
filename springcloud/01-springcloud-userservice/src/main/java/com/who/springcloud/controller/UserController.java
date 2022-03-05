package com.who.springcloud.controller;

import com.who.springcloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setName("who");
        user.setPassword("password");
        System.out.println("----------get-----------");
        return user;
    }
}
