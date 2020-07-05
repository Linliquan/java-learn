package com.rocketmq.study;

import com.rocketmq.study.producer.Demo05Producer;
import org.apache.rocketmq.client.producer.SendResult;
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
 * @create: 2020-06-16 13:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMqRadioApplication.class)
public class Demo01ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo05Producer producer;

    /**
     * 首先，执行 #test() 测试方法，先启动一个消费者分组 "demo05-consumer-group-DEMO_05" 的 Consumer 节点。
     * 然后，执行 #testSyncSend() 测试方法，先启动一个消费者分组 "demo05-consumer-group-DEMO_05" 的 Consumer 节点。
     * 同时，该测试方法，调用 Demo05ProducerTest#syncSend(id) 方法，同步发送了一条消息
     */
    @Test
    public void test() throws InterruptedException {
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = producer.syncSend(id);
        logger.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}