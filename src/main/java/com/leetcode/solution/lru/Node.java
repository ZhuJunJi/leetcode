package com.leetcode.solution.lru;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2022/1/3
 * @since 1.0
 */
public class Node<K,V> {

    protected K key;

    protected V val;

    protected Node<K, V> pre, next;

    public Node(K key, V val){
        this.key = key;
        this.val = val;
    }
}
