package com.who.springboot.Impl;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import services.IndexService;

@Component
@Service(interfaceClass = IndexService.class,version = "1.0.0",timeout = 15000)
public class IndexServiceImpl implements IndexService {

    @Override
    public String queryVersion() {
        return "1.0.0";
    }
}
