package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-2
 */
public interface Stack<E> {

    int getSize();

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();
}
