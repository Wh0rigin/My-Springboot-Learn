package com.who.springboot.serivce.impl;

import com.who.springboot.serivce.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
