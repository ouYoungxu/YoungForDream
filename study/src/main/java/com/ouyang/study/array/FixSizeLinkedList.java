package com.ouyang.study.array;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * 固定长度List
 * 如果List里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
 * @author: ouyangxu
 * @Date: 2019年12月04日 下午 05:57
 */
public class FixSizeLinkedList<T> extends LinkedList<T> {
    private static final long serialVersionUID = -645040731909659095L;

    /**
     * 定义缓存的容量
     */
    private int capacity;

    public FixSizeLinkedList(int capacity) {
        super();
        this.capacity = capacity;
    }

    @Override
    public boolean add(T t) {
        // 超过长度，移除最后一个
        if (size() + 1 > capacity) {
            super.removeFirst();
        }
        return super.add(t);
    }

    public static void main(String[] args) {
        FixSizeLinkedList<String> list = new FixSizeLinkedList<>(3);
        System.out.println(list.size());
        list.add("1");
        System.out.println(list.size());
        list.add("2");
        System.out.println(list.size());
        list.add("3");
        System.out.println(list.get(0));
        System.out.println(JSON.toJSONString(list));
        System.out.println();

        list.add("4");
        System.out.println(list.get(0));
        System.out.println(JSON.toJSONString(list));
        System.out.println();

        list.add("5");
        System.out.println(list.get(0));
        System.out.println(JSON.toJSONString(list));
        System.out.println();

        list.add("6");
        System.out.println(list.get(0));
        System.out.println(JSON.toJSONString(list));
        System.out.println();

    }
}
