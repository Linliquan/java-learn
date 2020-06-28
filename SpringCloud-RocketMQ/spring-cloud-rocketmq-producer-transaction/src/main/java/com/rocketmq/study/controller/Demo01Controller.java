package com.rocketmq.study.controller;

import com.alibaba.fastjson.JSON;
import com.rocketmq.study.message.Demo01Message;
import com.rocketmq.study.message.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 21:35
 **/
@RestController
@RequestMapping("/demo01")
public class Demo01Controller {

    @Autowired
    private MySource mySource;

    @GetMapping("/send_transaction")
    public boolean sendTransaction() {
        // 创建 Message
        Demo01Message message = new Demo01Message()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Args args = new Args().setArgs1(1).setArgs2("2");
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                .setHeader("args", JSON.toJSONString(args)) // <X>
                .build();
        // 发送消息
        return mySource.demo01Output().send(springMessage);
    }

    public static class Args { // 这里作为示例，所以直接这么写了

        private Integer args1;
        private String args2;

        public Integer getArgs1() {
            return args1;
        }

        public Args setArgs1(Integer args1) {
            this.args1 = args1;
            return this;
        }

        public String getArgs2() {
            return args2;
        }

        public Args setArgs2(String args2) {
            this.args2 = args2;
            return this;
        }

        @Override
        public String toString() {
            return "Args{" +
                    "args1=" + args1 +
                    ", args2='" + args2 + '\'' +
                    '}';
        }
    }

}