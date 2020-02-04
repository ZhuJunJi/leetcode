package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-5
 */
public class LinkedList<E> {

    private Node dummyHead;

    private int size;

    private Node curr;


    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed! index is Illegal!");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e,pre.next);
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public Node get(int index){
        if(index < 0 || index > size || size == 0){
            throw new IllegalArgumentException("Get failed!");
        }
        Node curr = dummyHead.next;
        while (index != 0){
            curr = curr.next;
            index--;
        }
        return curr;
    }

    public Node getFirst(){
        return get(0);
    }

    public Node getLast(){
        return get(size - 1);
    }

    public E delete(int index){
        if(index < 0 || size == 0 ||index >= size ){
            throw new IllegalArgumentException("Delete failed!");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.obj;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        res.append(String.format("LinkedList: size = %d\n",size));

        for (Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur).append("->");
        }

        res.append("NULL");

        return res.toString();
    }

    private class Node{

        public E obj;

        public Node next;

        public Node(E obj, Node next){
            this.obj = obj;
            this.next = next;
        }

        public Node (E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return obj.toString();
        }
    }
}
