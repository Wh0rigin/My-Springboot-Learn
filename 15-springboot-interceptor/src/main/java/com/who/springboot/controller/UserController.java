package com.who.springboot.controller;

import com.google.gson.Gson;
import com.who.springboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public ResponseEntity<Object> login( HttpServletRequest request){
//        Gson gson = new Gson();
//        User user = gson.fromJson(requestbody.toString(),User.class);
        User user = new User();
        user.setId(1);
        user.setName("root");
        user.setPassword("password");
        request.getSession().setAttribute("user",user);
        return new ResponseEntity<>("login SUCCESS", HttpStatus.OK);
    }

    //该页面需要用户登录后才可访问
    @GetMapping("/private")
    public Object pve(){
        return "private login";
    }

    @GetMapping("/public")
    public Object pblc(){
        return "public login";
    }

    @GetMapping("/error")
    public Object error(){
        return "Ultraviolet Access";
    }

}
