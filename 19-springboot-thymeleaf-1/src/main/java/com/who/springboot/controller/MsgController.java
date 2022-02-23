package com.who.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/msg")
public class MsgController {
    @RequestMapping("/show")
    public String show(Model model){
        model.addAttribute("data","ThyData");
        return "msg";
    }
}
