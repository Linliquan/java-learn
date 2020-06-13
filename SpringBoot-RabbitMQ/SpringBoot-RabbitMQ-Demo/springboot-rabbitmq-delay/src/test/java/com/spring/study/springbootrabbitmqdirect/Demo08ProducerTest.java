package com.spring.study.springbootrabbitmqdirect;


import com.spring.study.springbootrabbitmqdirect.producer.Demo08Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 14:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo08ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo08Producer producer;

    @Test
    public void testSyncSend01() throws InterruptedException {
        // 不设置消息的过期时间，使用队列默认的消息过期时间
        this.testSyncSendDelay(null);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("发送成功时间：{}",simpleDateFormat.format(new Date()));
    }

    @Test
    public void testSyncSend02() throws InterruptedException {
        // 设置发送消息的过期时间为 5000 毫秒
        this.testSyncSendDelay(5000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("发送成功时间：{}",simpleDateFormat.format(new Date()));
    }

    private void testSyncSendDelay(Integer delay) throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id, delay);
        logger.info("[testSyncSendDelay][发送编号：[{}] 发送成功]", id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("发送成功时间：{}",simpleDateFormat.format(new Date()));

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}