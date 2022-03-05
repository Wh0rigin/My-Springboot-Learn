package com.who.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping(value="/say")
    public String say(){
        return "Hello world!";
    }

    @RequestMapping(value="/mapvalue")
    public Map<String,Object> mapValue(){
        Map<String,Object> result = new HashMap<>();
        result.put("msg","SpringBoot Project");
        return result;
    }


    @RequestMapping(value="/getandsay")
    public Object getAndSay(String name,String msg){
        return name+':'+msg;
    }
}
