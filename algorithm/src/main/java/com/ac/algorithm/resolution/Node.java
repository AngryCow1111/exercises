package com.ac.algorithm.resolution;

/**
 * Node
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class Node {
    public Node(String data, String key) {
        this.data = data;
        this.key = key;
    }

    Node pre;
    Node next;
    String data;
    String key;
}
