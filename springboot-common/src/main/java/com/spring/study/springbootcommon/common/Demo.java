package com.spring.study.springbootcommon.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linliquan
 * @description: 这个<T> T 表示的是返回值T是泛型，T是一个占位符，用来告诉编译器，这个东西先给我留着，等我编译的时候，告诉你。
 * @create 2021/4/25 18:08
 */
public class Demo {

    public static void main(String[] args) {

        Demo demo = new Demo();
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        String s = demo.getList(list);
        System.out.println(s);

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        Integer num = demo.getList(nums);
        System.out.println(num);

    }

    /**
     * 这个<T> T 可以传入任何类型的List
     * 参数T
     *     第一个 表示是泛型
     *     第二个 表示返回的是T类型的数据
     *     第三个 限制参数类型为T
     * @param list
     * @return
     */
    private  <T> T getList(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }



}
