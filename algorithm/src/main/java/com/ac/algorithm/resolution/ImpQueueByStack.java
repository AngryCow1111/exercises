package com.ac.algorithm.resolution;

import java.util.Stack;

/**
 * ImpQueueByStack
 * 使用栈实现队列
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class ImpQueueByStack {

    static Stack<Integer> enQueueStack = new Stack<>();
    static Stack<Integer> deQueueStack = new Stack<>();

    public static void enQueue(Integer data) {
        enQueueStack.push(data);
    }

    public static Integer deQueue() {
        if (enQueueStack.isEmpty() && deQueueStack.isEmpty()) {
            return null;
        }

        if (!deQueueStack.isEmpty()) {
            return deQueueStack.pop();
        }
        while (!enQueueStack.isEmpty()) {
            deQueueStack.push(enQueueStack.pop());
        }
        if (deQueueStack.empty()) {
            return null;
        }
        return deQueueStack.pop();

    }

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);

        Integer integer = deQueue();
        integer = deQueue();
    }
}
