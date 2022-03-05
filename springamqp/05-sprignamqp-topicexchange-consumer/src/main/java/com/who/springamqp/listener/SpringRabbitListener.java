package com.who.springamqp.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpringRabbitListener {

    private SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "simple.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenQueue1Topic(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"direct.queue1:"+msg);
        Thread.sleep(100);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "simple.topic",type = ExchangeTypes.TOPIC),
            key = "usa.#"
    ))
    public void listenQueue2Topic(String msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"direct.queue2:"+msg);
        Thread.sleep(100);
    }
}
