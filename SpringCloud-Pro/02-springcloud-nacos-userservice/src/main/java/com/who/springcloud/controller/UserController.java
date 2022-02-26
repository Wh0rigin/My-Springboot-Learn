package com.who.springcloud.controller;

import com.who.springcloud.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/user")
//@RefreshScope   //配置Nacos配置文件热更新
public class UserController {
    //热部署测试
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setName("who");
        user.setPassword("password");
//        System.out.println("----------get:"+dateformat+"----------");
        return user;
    }
//热部署测试
//    @GetMapping("/now")
//    public String now(){
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat, Locale.CHINA));
//    }
}
