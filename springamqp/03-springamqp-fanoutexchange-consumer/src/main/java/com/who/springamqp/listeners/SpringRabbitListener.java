package com.who.springamqp.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpringRabbitListener {
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
    @RabbitListener(queues = "fanout.queue1")
    @RabbitHandler
    public void listenQueue1(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"fanout.queue1:"+msg);
        Thread.sleep(10);
    }

    @RabbitListener(queues = "fanout.queue2")
    @RabbitHandler
    public void listenQueue2(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"fanout.queue2:"+msg);
        Thread.sleep(100);
    }
}
