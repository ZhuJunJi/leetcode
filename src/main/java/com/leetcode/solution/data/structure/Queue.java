package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-3
 */
public interface Queue<E> {

    /**
     * 入队列
     * @param e 入队元素
     */
    void enqueue(E e);

    /**
     * 出队列
     * @return 出队元素
     */
    E dequeue();

    /**
     * 获取头元素
     * @return 头元素
     */
    E getFront();

    /**
     * 获取元素个数
     * @return 元素个数
     */
    int getSize();

    /**
     * 获取容量
     * @return 容量
     */
    int getCapacity();

    /**
     * 队列是否为空
     * @return true:空 false:不为空
     */
    boolean isEmpty();
}
