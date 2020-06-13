package com.spring.study.springbootrabbitmqdirect.message;

import java.io.Serializable;

/**
 * @program: java-learn
 * @description: 消息类，提供给当前示例使用
 * @author: liquan
 * @create: 2020-06-10 14:54
 **/
public class ClusteringMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

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
        return "ClusteringMessage{" +
                "id=" + id +
                '}';
    }
}