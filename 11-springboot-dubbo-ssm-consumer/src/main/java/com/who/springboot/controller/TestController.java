package com.who.springboot.controller;

import com.who.springboot.model.Test;
import com.who.springboot.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {

    @Reference(interfaceClass = TestService.class,version = "1.0.0",check = false)
    private TestService testService;

    @GetMapping("detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        Test test = testService.queryTestById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("test",test);
        mv.setViewName("testdetail");
        return mv;
    }

    @GetMapping("all/count")
    public ModelAndView detail(){
        Integer count = testService.queryAllTestCount();
        ModelAndView mv = new ModelAndView();
        mv.addObject("count",count);
        mv.setViewName("testcount");
        return mv;
    }
}
