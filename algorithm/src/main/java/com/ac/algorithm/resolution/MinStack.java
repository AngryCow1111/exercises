package com.ac.algorithm.resolution;

import java.util.Stack;

/**
 * MinStack
 * 实现具有出栈，入栈以及获取最小值的功能的栈；
 * 时间复杂度要为O(1)
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class MinStack {
    /**
     * 基本思路：从最简单的思路来思考，
     * stack本来就具有入栈、出栈；
     * 获取最小值时，我们之前的基本思路就每次入栈需要通过入栈的值和当前的最小值进行比较，选择两者较小的值为最小值；
     * 但是这个没考虑到出栈的情况：
     * 比如当前栈为1,5,7,9,3  此时最小值为3.
     * 如果此时出栈，此时栈内元素为1,5,7,9。 这时候就不知道最小值是啥了。需要从头遍历来寻找最小值。时间复杂度为O(n);
     * 所以需要记录历史最小值，并且需要先入后出，正好栈就能满足这个特性；
     */

    static Stack<Integer> dataStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void push(Integer data) {
        dataStack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    public static Integer pop() {
        if (!minStack.isEmpty() && minStack.peek().equals(dataStack.peek())) {
            minStack.pop();
        }
        return dataStack.pop();
    }

    public static Integer getMin() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.pop();
    }

    public static void main(String[] args) {
        push(4);
        push(8);
        push(4);
        push(11);
        push(7);
        push(3);

        Integer min = getMin();
        min = getMin();
        System.out.println(min);
    }
}
