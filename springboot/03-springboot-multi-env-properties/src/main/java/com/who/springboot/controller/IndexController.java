package com.who.springboot.controller;

import com.who.springboot.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class IndexController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private User user;

    @RequestMapping(value="/say")
    @ResponseBody
    public String say(){
        return "hello Multi-env" + ":" + port;
    }


    @RequestMapping(value="/user")
    @ResponseBody
    public String user(){
        return '{'+ "name:" + user.getName() + "," +"password:" + user.getPwd()+'}';
    }
}
