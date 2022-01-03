package com.leetcode.solution.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2022/1/3
 * @since 1.0
 */
public class LRUCache<K, V> {

    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;

    private DoubleLinkedList<K, V> doubleLinkedList;

    private Map<K, Node<K, V>> map;

    public LRUCache(int initialCapacity){
        if (initialCapacity > 0) {
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        doubleLinkedList = new DoubleLinkedList<>();
        map = new HashMap<>();
    }

    /**
     * 只要使用了就将使用的 key 放到最前边
     * @param key
     * @return V
     */
    public V get(K key){
        if(map.containsKey(key)){
            Node<K, V> node = map.get(key);
            V val = node.val;
            put(key, val);
            return val;
        }
        return null;
    }

    public void put(K key, V val){
        if(map.containsKey(key)){
            Node<K, V> node = map.get(key);
            doubleLinkedList.remove(node);
            node.val = val;
            doubleLinkedList.addFirst(node);
        }else {
            if(isFull()){
                // 删除末尾
                Node<K, V> last = doubleLinkedList.getLast();
                doubleLinkedList.remove(last);
                map.remove(last.key);
            }
            Node<K, V> node = new Node<>(key, val);
            doubleLinkedList.addFirst(node);
            map.put(key, node);
        }
    }

    public boolean isEmpty(){
        return doubleLinkedList.size() == 0;
    }

    public boolean isFull(){
        return doubleLinkedList.size() == capacity;
    }

}
