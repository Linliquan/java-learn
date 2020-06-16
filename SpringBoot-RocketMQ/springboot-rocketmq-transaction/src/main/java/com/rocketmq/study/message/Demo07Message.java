package com.rocketmq.study.message;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 12:28
 **/
public class Demo07Message {

    public static final String TOPIC = "DEMO_07";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo07Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo07Message{" +
                "id=" + id +
                '}';
    }
}