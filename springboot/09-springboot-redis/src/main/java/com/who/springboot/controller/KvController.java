package com.who.springboot.controller;

import com.who.springboot.serives.KvSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class KvController {
    @Autowired
    private KvSerive kvSerive;

    @GetMapping("put/{key}/{value}")
    public Object put(@PathVariable String key,@PathVariable String value){
        kvSerive.putKv(key,value);
        return "值成功插入redis";
    }

    @GetMapping("get/{key}")
    public Object get(@PathVariable String  key){
        String value = kvSerive.getValue(key);
        return "The value is "+ value;
    }
}
