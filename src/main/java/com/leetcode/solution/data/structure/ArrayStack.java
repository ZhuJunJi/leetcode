package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-2
 */
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array(capacity);
    }

    public ArrayStack() {
        array = new Array();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public boolean isEmpty(){
        return getSize() == 0;
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = array.getSize();
        stringBuilder.append(String.format("Stack: size = %d, capacity = %d, data = [",size,array.getCapacity()));
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array.get(i));
            if(i != size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Object> objects = new ArrayStack<>(1);
        objects.push(1);
        System.out.println(objects);
        objects.push(2);
        System.out.println(objects);
        Object pop = objects.pop();

        Object pop1 = objects.pop();
        System.out.println(objects);
        System.out.println(objects.isEmpty());
        System.out.println(pop);
        System.out.println(objects);
    }
}
