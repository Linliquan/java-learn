package com.spring.study.springbootrabbitmqdirect.message;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-06 21:31
 **/
@Component
public class Demo01Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_01";

    public static final String EXCHANGE = "EXCHANGE_DEMO_01";

    public static final String ROUTING_KEY = "ROUTING_KEY_01";

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
        return "Demo01Message{" +
                "id=" + id +
                '}';
    }
}
