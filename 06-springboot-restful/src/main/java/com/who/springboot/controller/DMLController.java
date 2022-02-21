package com.who.springboot.controller;

import com.who.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class DMLController {

    @Autowired
    private UserService userService;

    @GetMapping("/select/id/{id}")
    public String select(@PathVariable Integer id){
        return null;
    }

    @GetMapping("/select/name/{name}")
    public String select(@PathVariable String name){
        return null;
    }

    @PostMapping("insert/{name}/{pwd}")
    public String insert(@PathVariable String name,@PathVariable String pwd){
        return null;
    }

    @PutMapping("{name}/{pwd}")
    public String update(@PathVariable String name,@PathVariable String pwd){
        return null;
    }

    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable String name){
        return null;
    }
}
