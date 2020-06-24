package com.rocketmq.study.message;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 21:34
 **/
public class Demo01Message {

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo01Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo01Message{" +
                "id=" + id +
                '}';
    }
}
