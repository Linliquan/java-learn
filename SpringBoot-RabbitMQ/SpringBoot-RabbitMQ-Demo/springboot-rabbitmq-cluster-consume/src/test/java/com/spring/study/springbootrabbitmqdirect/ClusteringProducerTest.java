package com.spring.study.springbootrabbitmqdirect;


import com.spring.study.springbootrabbitmqdirect.producer.ClusteringProducer;
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
public class ClusteringProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClusteringProducer producer;

    @Test
    public void mock() throws InterruptedException {
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSend() throws InterruptedException {
        // 发送 3 条消息
        for (int i = 0; i < 3; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);
            logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}