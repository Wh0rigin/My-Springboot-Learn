package com.who.springamqp.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Component
public class SpringRabbitListener {

    private SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

    @RabbitListener(queuesToDeclare = {@Queue("convert.queue1")})
    public void listenQueue1Msg(HashMap<String,String> msg) throws InterruptedException {
        Date date = new Date();
        System.out.println("【"+dateFormat.format(date.getTime())+"】"+"convert.queue1:"+msg.toString());
        Thread.sleep(100);
    }
}
