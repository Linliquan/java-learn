package com.spring.study.springbootrabbitmqdirect.producer;


import com.spring.study.springbootrabbitmqdirect.message.Demo07Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 11:54
 **/
@Component
public class Demo07Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo07Message 消息
        Demo07Message message = new Demo07Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo07Message.EXCHANGE, Demo07Message.ROUTING_KEY, message);
    }

    public void syncSendDefault(Integer id) {
        // 创建 Demo07Message 消息
        Demo07Message message = new Demo07Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo07Message.QUEUE, message);
    }

    @Async
    public ListenableFuture<Void> asyncSend(Integer id) {
        try {
            // 发送消息
            this.syncSend(id);
            // 返回成功的 Future
            return AsyncResult.forValue(null);
        } catch (Throwable ex) {
            // 返回异常的 Future
            return AsyncResult.forExecutionException(ex);
        }
    }

}