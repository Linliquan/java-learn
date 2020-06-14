package com.springcloud.study.message;

/**
 * @program: java-learn
 * @description: 创建 Demo01Message 类，示例 Message 消息。
 * @author: liquan
 * @create: 2020-06-12 23:33
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
