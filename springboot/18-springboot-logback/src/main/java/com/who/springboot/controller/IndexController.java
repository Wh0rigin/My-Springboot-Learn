package com.who.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class IndexController {
    @GetMapping("/")
    public Object index(){
        log.info("---index---");
        return "index";
    }
}
