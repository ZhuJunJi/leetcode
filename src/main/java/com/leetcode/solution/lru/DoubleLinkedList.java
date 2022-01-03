package com.leetcode.solution.lru;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2022/1/3
 * @since 1.0
 */
public class DoubleLinkedList<K, V> {

    private Node<K, V> head;

    private Node<K, V> last;

    private int size;

    public DoubleLinkedList(){
        this.size = 0;
    }

    public void addFirst(Node<K, V> node) {
        if(this.size == 0){
            head = node;
            last = node;
        }else {
            head.pre = node;
            node.next = head;
            head = node;
        }

        size++;
    }


    public void remove(Node<K, V> node) {
        Node<K, V> pre = node.pre;
        Node<K, V> next = node.next;
        if(pre != null){
            pre.next = next;
        }
        if(next != null){
            next.pre = pre;
        }
        if(this.head == node){
            this.head = next;
        }
        if(this.last == node){
            this.last = pre;
        }
        node.pre = null;
        node.next = null;
        size--;
    }

    public Node<K, V> removeLast(){
        Node<K, V> last = this.last;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public Node<K, V> getLast() {
        return last;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
