package com.spring.study.springbootrabbitmqdirect.message;

import java.io.Serializable;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 11:52
 **/
public class Demo04Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_04_A";

    public static final String EXCHANGE = "EXCHANGE_DEMO_04";

    public static final String HEADER_KEY = "color";
    public static final String HEADER_VALUE = "red";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo04Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo04Message{" +
                "id=" + id +
                '}';
    }
}
