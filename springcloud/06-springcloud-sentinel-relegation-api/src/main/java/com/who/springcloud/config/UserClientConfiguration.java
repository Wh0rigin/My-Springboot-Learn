package com.who.springcloud.config;


import com.who.springcloud.clients.UserClient;
import com.who.springcloud.fallback.UserClientFallbackFactory;
import com.who.springcloud.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class UserClientConfiguration{
    @Bean
    public UserClientFallbackFactory userClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }

}