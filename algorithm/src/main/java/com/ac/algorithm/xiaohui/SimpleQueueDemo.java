package com.ac.algorithm.xiaohui;

/**
 * SimpleQueueDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-04
 */
public class SimpleQueueDemo {


    int[] array;
    int rear;
    int front;

    public SimpleQueueDemo(int capacity) {
        array = new int[capacity];
    }

    public void enqueue(int element) {
        /**
         * 判断是否队满
         */
        if ((rear + 1) % array.length == front) {
            throw new RuntimeException();
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int dequeue() {
        /**
         * 判断是否队空
         */
        if (rear == front) {
            throw new RuntimeException();
        }
        int dequeueElement = array[front];
        front = (front + 1) % array.length;
        return dequeueElement;
    }

    public void print() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        SimpleQueueDemo simpleQueueDemo = new SimpleQueueDemo(6);
        simpleQueueDemo.enqueue(3);
        simpleQueueDemo.enqueue(5);
        simpleQueueDemo.enqueue(6);
        simpleQueueDemo.enqueue(1);
        simpleQueueDemo.enqueue(9);
        simpleQueueDemo.dequeue();
        simpleQueueDemo.print();

    }
}
