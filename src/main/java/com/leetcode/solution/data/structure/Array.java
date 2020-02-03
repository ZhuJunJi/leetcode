package com.leetcode.solution.data.structure;

/**
 * @author  zhujunji
 * @date 2020-02-1
 */
@SuppressWarnings("all")
public class Array<E> {

    private E[] data;

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取当前容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将元素添加到末尾
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 将元素添加到起始位子
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 指定索引上添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index is Illegal");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity 容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 删除指定索引上的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Delete failed.Index is Illegal");
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return e;
    }

    /**
     * 移除末尾元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 移除首位元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 获取指定索引上的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is Illegal");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改执行索引上的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed.Index is Illegal");
        }
        data[index] = e;
    }

    /**
     * 数组是否包含目标元素
     *
     * @param target
     * @return
     */
    public boolean contains(E target) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取目标元素的索引
     *
     * @param target
     * @return
     */
    public int find(E target) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size =  %d, capacity = %d, data = ", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array(3);
        array.addLast(66);
        array.addLast(88);
        array.addLast(99);
        System.out.println(array);

        array.add(1, 77);
        System.out.println(array);

        System.out.println(array.remove(1));
        System.out.println(array);
    }
}
