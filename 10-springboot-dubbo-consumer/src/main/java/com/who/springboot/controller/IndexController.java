package com.who.springboot.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IndexService;

@RestController
@RequestMapping("/")
public class IndexController {

    @Reference(interfaceClass = IndexService.class,version = "1.0.0",check = false)
    private IndexService indexService;

    @GetMapping("version")
    public Object version(){
        String version = indexService.queryVersion();
        return "当前版本为" + version;
    }
}
