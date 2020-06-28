package com.rocketmq.study;

import com.rocketmq.study.producer.Demo02Producer;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 13:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMqBatchApplication.class)
public class Demo01ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo02Producer producer;

    @Test
    public void testSendBatch() throws InterruptedException {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        SendResult result = producer.sendBatch(ids);
        logger.info("[testSendBatch][发送编号：[{}] 发送结果：[{}]]", ids, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}