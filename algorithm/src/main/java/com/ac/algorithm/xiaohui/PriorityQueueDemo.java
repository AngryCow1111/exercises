package com.ac.algorithm.xiaohui;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * PriorityQueueDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/5
 */
public class PriorityQueueDemo {

    int[] array = new int[32];
    /**
     * 队列实际大小
     */
    int size = 0;

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(int element) {
        /**
         * 需要扩容
         */
        if (size >= array.length) {
            resize();
        }
        array[size] = element;
        size++;
        upAdjust();

    }

    private void resize() {
        array = Arrays.copyOf(array, size << 1);
//        int[] newArray= new int[size<<1];
//        System.arraycopy(array,0,newArray,0,array.length);
    }

    public int deQueue() {

        if (size <= 0) {
            throw new RuntimeException();
        }
        int head = array[0];
        size--;
        array[0] = array[size];
        downAdjust();
        return head;
    }

    /**
     * 子节点上浮
     */
    public void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = childIndex >> 1;
        int temp = array[childIndex];
        /**
         * 子节点大于父节点
         */
        while (array[childIndex] > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex >> 1;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉父节点
     */
    public void downAdjust() {
        int parnentIndex = 0;
        /**
         * 获得要下沉的子节点下标
         */
        int childIndex = parnentIndex << 1 + 1;
        int temp = array[parnentIndex];
        /**
         *childIndex未达到越界
         */
        while (childIndex < size) {
            /**
             * 右节点大于左节点，使用右节点（较大者）
             */
            if (childIndex + 1 < size && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            if (array[parnentIndex] < array[childIndex]) {
                break;
            }
            array[parnentIndex] = array[childIndex];
            parnentIndex = childIndex;
            childIndex = childIndex << 1 + 1;
        }
        array[parnentIndex] = temp;
    }
    public static void main(String[] args) {
        PriorityQueueDemo priorityQueueDemo = new PriorityQueueDemo();
        priorityQueueDemo.enQueue(3);
        priorityQueueDemo.enQueue(11);
        priorityQueueDemo.enQueue(7);
        priorityQueueDemo.enQueue(2);
        priorityQueueDemo.enQueue(1);

        System.out.println(priorityQueueDemo.deQueue());

    }
}
