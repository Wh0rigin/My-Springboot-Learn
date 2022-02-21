package com.who.springboot.controller;

import com.google.gson.Gson;
import com.who.springboot.resources.User;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("login/detail/{name}/{password}")
    public Object restlogin(@PathVariable("name") String name,@PathVariable("password") String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }

    @PostMapping("regis")
    public ResponseEntity<Object> regisPost(@RequestBody Object requestbody, HttpServletRequest request,
                                            HttpServletResponse response, HttpMethod method){
        Gson gson = new Gson();
        User user123 = gson.fromJson(requestbody.toString(),User.class);
        return new ResponseEntity<>("hello,"+request.getMethod().toString()+":Name."+user123.getName()+
                ";Password:"+user123.getPassword()+";\n"+requestbody.toString(), HttpStatus.OK);
    }

//    @GetMapping("login")
//    public Object login(String name,String password){
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        return user;
//    }
}
