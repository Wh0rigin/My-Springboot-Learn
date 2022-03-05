package com.who.springamqp.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//这里注意在bean交给spring管理后想要调用对应的实体，必须名称相同
@Configuration
public class FanoutConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;


    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange("simple.fanout",true,false);
        rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }

//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange("simple.fanout");
//    }


    @Bean
    public Queue fanoutQueue1(){
        Queue queue1 = new Queue("fanout.queue1");
        rabbitAdmin.declareQueue(queue1);
        return queue1;
    }

    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange){
        Binding binding = BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Queue fanoutQueue2(){
        Queue queue2 = new Queue("fanout.queue2");
        rabbitAdmin.declareQueue(queue2);
        return queue2;
    }

    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        Binding binding = BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

}
