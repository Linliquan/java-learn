package com.springcloud.study.listener;

import com.rabbitmq.client.Channel;
import com.springcloud.study.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @program: java-learn
 * @description: 创建 Demo01Controller 类，提供发送消息的 HTTP 接口
 * @author: liquan
 * @create: 2020-06-12 23:34
 **/
@Component
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AtomicInteger index = new AtomicInteger();

    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload Demo01Message message,
                          @Header(AmqpHeaders.CHANNEL) Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 提交消费进度
        if (index.incrementAndGet() == 1) {
            // ack 确认消息
            // 第二个参数 multiple ，用于批量确认消息，为了减少网络流量，手动确认可以被批处。
            // 1. 当 multiple 为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息
            // 2. 当 multiple 为 false 时，则只确认当前 deliveryTag 对应的消息
            channel.basicAck(deliveryTag, false);
        }
    }

}