package com.who.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping(value="/say")
    public ModelAndView say(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","hello springboot");
        mv.setViewName("say");
        return mv;
    }

    @RequestMapping(value="/print")
    public String print(Model model){
        model.addAttribute("msg","hello,world");
        return "say";
    }
}
