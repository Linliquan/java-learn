package com.spring.study.springbootrabbitmqdirect.message;

import java.io.Serializable;

/**
 * @program: java-learn
 * @description: 消息类，提供给当前示例使用
 * @author: liquan
 * @create: 2020-06-10 15:45
 **/
public class BroadcastMessage implements Serializable {

    public static final String QUEUE = "QUEUE_BROADCASTING";

    public static final String EXCHANGE = "EXCHANGE_BROADCASTING";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "id=" + id +
                '}';
    }
}
