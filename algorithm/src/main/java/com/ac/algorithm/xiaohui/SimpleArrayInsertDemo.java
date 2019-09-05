package com.ac.algorithm.xiaohui;

/**
 * SimpleArrayInsertDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-03
 */
public class SimpleArrayInsertDemo {

    private int size = 0;
    private int[] array;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_ARRAY_CAPACITY = 1 << 4;


    public SimpleArrayInsertDemo() {
        array = new int[DEFAULT_ARRAY_CAPACITY];

    }

    public SimpleArrayInsertDemo(int capacity) {
        array = new int[capacity];
    }

    public void insert(int num, int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException("out of array index");
        }
        if (size > array.length * DEFAULT_LOAD_FACTOR) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = num;
        size++;

    }

    /**
     * 扩容
     */
    private void resize() {
        int newCapacity = array.length << 1;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void print() {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        SimpleArrayInsertDemo simpleArrayInsertDemo = new SimpleArrayInsertDemo(4);
        simpleArrayInsertDemo.insert(3, 0);
        simpleArrayInsertDemo.insert(7, 1);
        simpleArrayInsertDemo.insert(9, 2);
        simpleArrayInsertDemo.insert(8, 1);
        simpleArrayInsertDemo.insert(6, 1);
        simpleArrayInsertDemo.print();
    }


}
