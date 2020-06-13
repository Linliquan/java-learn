package com.spring.study.springbootrabbitmqdirect;


import com.spring.study.springbootrabbitmqdirect.producer.Demo051Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 14:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo051Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            // 同步发送消息
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);

            // 故意每条消息之间，隔离 10 秒
            logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
            Thread.sleep(5 * 1000L);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}