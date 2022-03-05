package com.who.springamqp.listeners;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue1(String msg){
        System.out.println("consumer1:"+msg);
    }


}
