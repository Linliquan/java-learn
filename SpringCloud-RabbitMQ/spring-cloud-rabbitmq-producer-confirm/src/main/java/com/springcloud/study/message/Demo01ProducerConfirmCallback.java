package com.springcloud.study.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description: 监听类
 * @author: liquan
 * @create: 2020-06-14 16:50
 **/
@Component
public class Demo01ProducerConfirmCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ServiceActivator(inputChannel = "demo01-producer-confirm")
    public void onPublisherConfirm(Message message) {
        logger.info("[onPublisherConfirm][headers：{}]", message.getHeaders());
        logger.info("[onPublisherConfirm][payload：{}]", message.getPayload());
    }

}