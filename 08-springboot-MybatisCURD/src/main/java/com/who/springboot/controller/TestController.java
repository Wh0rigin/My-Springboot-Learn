package com.who.springboot.controller;

import com.google.gson.Gson;
import com.who.springboot.model.Test;
import com.who.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * a class about CURD
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("detail/{id}")
    public Object getById(@PathVariable Integer id){
        Test test = testService.queryTestById(id);
        return test;
    }

    @PutMapping("update")
    public ResponseEntity<Object> updatePut(@RequestBody Object requestbody, HttpServletRequest request,
                                            HttpServletResponse response, HttpMethod method){
        Gson gson = new Gson();
        Test test = gson.fromJson(requestbody.toString(),Test.class);
        boolean result = testService.updateTestById(test.getId(),test.getName(),test.getPassword());
        return new ResponseEntity<>("{status:"+result+"}", HttpStatus.OK);
    }

    @PostMapping("regis")
    public ResponseEntity<Object> regisPost(@RequestBody Object requestbody, HttpServletRequest request,
                                            HttpServletResponse response, HttpMethod method){
        Gson gson = new Gson();
        Test test = gson.fromJson(requestbody.toString(),Test.class);
        boolean result = testService.insertTestById(test.getName(),test.getPassword());
        return new ResponseEntity<>("{status:"+result+"}", HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> deleteById(@RequestBody Object requestbody, HttpServletRequest request,
                              HttpServletResponse response, HttpMethod method){
        Gson gson = new Gson();
        Test test = gson.fromJson(requestbody.toString(),Test.class);
        boolean result = testService.deleteTestById(test.getId());
        return new ResponseEntity<>("{status:"+result+"}", HttpStatus.OK);
    }
}
