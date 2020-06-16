package com.rocketmq.study.message;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 12:28
 **/
public class Demo01Message {

    public static final String TOPIC = "DEMO_01";

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