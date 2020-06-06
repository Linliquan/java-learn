package com.spring.study.springbootrabbitmqdirect;

import com.spring.study.springbootrabbitmqdirect.producer.Demo01Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRabbitmqDirectApplicationTests {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Demo01Producer producer;

	@Test
	public void testSyncSend() throws InterruptedException {
		int id = (int) (System.currentTimeMillis() / 1000);
		producer.syncSend(id);
		logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

		// 阻塞等待，保证消费
		new CountDownLatch(1).await();
	}

	@Test
	public void tesSyncSendDefault() throws InterruptedException {
		int id = (int) (System.currentTimeMillis() / 1000);
		producer.syncSendDefault(id);
		logger.info("[tesSyncSendDefault][发送编号：[{}] 发送成功]", id);

		// 阻塞等待，保证消费
		new CountDownLatch(1).await();
	}

	@Test
	public void testAsyncSend() throws InterruptedException {
		int id = (int) (System.currentTimeMillis() / 1000);
		producer.asyncSend(id).addCallback(new ListenableFutureCallback<Void>() {

			@Override
			public void onFailure(Throwable e) {
				logger.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
			}

			@Override
			public void onSuccess(Void aVoid) {
				logger.info("[testASyncSend][发送编号：[{}] 发送成功，发送成功]", id);
			}

		});
		logger.info("[testASyncSend][发送编号：[{}] 调用完成]", id);

		// 阻塞等待，保证消费
		new CountDownLatch(1).await();
	}

}
