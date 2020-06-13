package com.spring.study.springbootrabbitmqdirect.consumer;

/**
 * @program: java-learn
 * @description: 消费者
 * @author: liquan
 * @create: 2020-06-09 15:29
 **/
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "test_queue_1")
    public void receive(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息接收时间:"+sdf.format(new Date()));
        System.out.println("接收到的消息:"+msg);
    }
}