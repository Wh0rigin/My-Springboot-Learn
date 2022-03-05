package com.who.springamqp.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpringRabbitListener {

    private SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange=@Exchange(value = "simple.direct",type = ExchangeTypes.DIRECT),
            key = {"A","B"}
    ))
    public void listenQueue1(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"direct.queue1:"+msg);
        Thread.sleep(10);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange=@Exchange(value = "simple.direct",type = ExchangeTypes.DIRECT),
            key = {"A","C"}
    ))
    public void listenQueue2(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"direct.queue2:"+msg);
        Thread.sleep(100);
    }
}
