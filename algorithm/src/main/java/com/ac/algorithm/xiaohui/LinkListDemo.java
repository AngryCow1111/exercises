package com.ac.algorithm.xiaohui;

/**
 * LinkListDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-04
 */
public class LinkListDemo {
    private Node head;
    private Node last;
    private int size = 0;

    public void insert(int data, int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException();
        }

        Node insertNode = new Node(data);
        if (0 == size) {
            head = insertNode;
            last = insertNode;
        } else if (size == index) {
            last.setNext(insertNode);
            last = insertNode;
        } else {
            Node preNode = getNode(index - 1);
            Node nextNode = preNode.getNext();
            preNode.setNext(insertNode);
            insertNode.setNext(nextNode);
        }
        size++;

    }


    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.getNext();
        } else if (index == size - 1) {
            Node preNode = getNode(index - 1);
            removeNode = preNode.getNext();
            preNode.setNext(null);
            last = preNode;
        } else {
            Node preNode = getNode(index - 1);
            removeNode = preNode.getNext();
            Node nextNode = removeNode.getNext();
            preNode.setNext(nextNode);
        }
        size--;
        return removeNode;
    }

    public Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();

        }
        return temp;
    }

    public void print() {
        Node temp = head;
        while (null != temp) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        LinkListDemo linkListDemo = new LinkListDemo();
        linkListDemo.insert(3, 0);
        linkListDemo.insert(4, 1);
        linkListDemo.insert(6, 2);
        linkListDemo.insert(9, 3);
        linkListDemo.insert(2, 3);
        linkListDemo.remove(2);

        linkListDemo.print();
    }
}
