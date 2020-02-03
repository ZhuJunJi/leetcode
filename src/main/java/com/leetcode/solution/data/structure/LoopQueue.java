package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-3
 */
@SuppressWarnings("all")
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int size;

    private int front;

    private int tail;

    private int capacity;

    public LoopQueue(int capacity){
        this.capacity = capacity;
        data = (E[]) new Object[capacity + 1];
        size = front = tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 进入队列
     * @param e
     */
    @Override
    public void enqueue(E e) {

        if(size == capacity){
            resize(capacity * 2);
        }

        data[tail] = e;

        tail = (tail + 1) % (data.length);

        size++;
    }

    /**
     * 重置容队列容量
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = front,j = 0; j < size; i = (i + 1) % data.length, j++) {
            newData[j] = data[i];
        }
        data = newData;
        front = 0;
        tail = size;
        capacity = newCapacity;
    }

    /**
     * 移出队列
     * @return
     */
    @Override
    public E dequeue() {

        E frontElement = getFront();

        front = (front + 1) % (data.length);

        size--;

        return frontElement;
    }

    @Override
    public E getFront() {

        // 队列为空
        if(front == tail){
            throw new IllegalArgumentException("Dequeue failed, Queue is empty!");
        }

        if(size == data.length / 4 && capacity / 2 != 0){
            resize(capacity / 2);
        }

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue: size = %d, capacity = %d, data = [", size, data.length));
        for (int i = front, j = 0; j < size; i = (i + 1) % data.length, j++) {
            stringBuilder.append(data[i]);
            if(j != size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<>(2);
        integerLoopQueue.enqueue(1);
        integerLoopQueue.enqueue(2);
        integerLoopQueue.enqueue(3);
        integerLoopQueue.enqueue(4);
        System.out.println(integerLoopQueue);
        System.out.println(integerLoopQueue.dequeue());
        System.out.println(integerLoopQueue.dequeue());
        System.out.println(integerLoopQueue.dequeue());
        System.out.println(integerLoopQueue);
        integerLoopQueue.enqueue(5);
        integerLoopQueue.enqueue(6);
        integerLoopQueue.enqueue(7);
        integerLoopQueue.enqueue(8);
        integerLoopQueue.enqueue(9);
        integerLoopQueue.enqueue(10);
        integerLoopQueue.enqueue(11);
        integerLoopQueue.enqueue(12);
        integerLoopQueue.enqueue(13);
        integerLoopQueue.enqueue(14);
        integerLoopQueue.enqueue(15);
        System.out.println(integerLoopQueue);
    }
}
