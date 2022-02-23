package com.who.springboot.service.impl;

import com.who.springboot.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public String sayHello() {
        return "hello";
    }
}
