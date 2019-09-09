package com.ac.algorithm.resolution;

import com.ac.algorithm.xiaohui.Node;

/**
 * LinkedListCloseLoopOptimized
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class LinkedListCloseLoopOptimized {
    public static Node circleInPoint(Node head) {
        /**
         * 判断是否存在回环，不存在就直接返回null；
         * 否则寻找入环点
         */
        if (!isLoop(head)) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        /**
         * 记录相遇的次数，在第二次时，结束获取入环点。
         */
        int count = 0;
        while (p2 != null && p2.getNext() != null) {
            p1 = p1.getNext();
            /**
             * 第一相遇前，p2每次移动跨度为2；
             * 之后跨度为1
             */
            if (count == 0) {
                p2 = p2.getNext().getNext();

            } else {
                p2 = p2.getNext();
            }
            if (p1 == p2) {
                /**
                 * 将p1重置为链表头节点
                 */
                count++;
                if (count == 1) {
                    p1 = head;
                    continue;
                }
                return p1;
            }
        }
        return null;
    }

    public static boolean isLoop(Node head) {
        boolean isLoop = false;
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        /**
         * 计算链表回环长度
         */
        int circleLength = -1;
        while (p2 != null && p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p1 == p2 || isLoop) {
                if (p1 == p2) {
                    count++;
                }
                isLoop = true;
                circleLength++;
                if (count == 2) {
                    break;
                }
            }
        }
        System.out.println(circleLength);
        return isLoop;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node2);
        boolean isLoop = isLoop(node1);
        System.out.println(isLoop);

        Node circleInPoint = circleInPoint(node1);
        System.out.println(circleInPoint.getData());

    }
}
