package com.who.springamqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertConfig {
    @Bean
    public MessageConverter jsonMessageConvert(){
        return new Jackson2JsonMessageConverter();
    }
}
