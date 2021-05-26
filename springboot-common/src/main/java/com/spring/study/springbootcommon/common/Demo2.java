package com.spring.study.springbootcommon.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linliquan
 * @description: 返回值，直接写T表示限制参数的类型，这种方法一般多用于共同操作一个类对象，然后获取里面的集合信息啥的。
 * @create 2021/4/25 18:08
 */
public class Demo2<T> {

    public static void main(String[] args) {

        Demo2<String> demo2 = new Demo2<>();
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        String s = demo2.getList(list);
        System.out.println(s);

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        Demo2<Integer> demo3 = new Demo2<>();
        Integer num = demo3.getList(nums);
        System.out.println(num);
        System.out.println(num);
        System.out.println(s + num);

    }

    /**
     * 这个只能传递T类型的数据
     * 返回值 就是Demo<T> 实例化传递的对象类型
     * @param list
     * @return
     */
    private T getList(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }



}
