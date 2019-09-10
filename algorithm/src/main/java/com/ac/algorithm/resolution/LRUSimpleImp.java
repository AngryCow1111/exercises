package com.ac.algorithm.resolution;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUSimpleImp
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class LRUSimpleImp {
    int limit;
    Map<String, Node> hashMap;
    Node head;
    Node end;

    public LRUSimpleImp(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>(limit);
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (null == node) {
            return null;
        }

        refreshNode(node);

        return node.data;
    }

    public void put(String key, String data) {
        Node node = hashMap.get(key);
        if (null == node) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            Node newNode = new Node(key, data);
            addNode(newNode);
            hashMap.put(key, newNode);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refreshNode(Node node) {
        /**
         * 如果访问的尾部，那么不用动；否则，将节点设置为最新即放到尾部;
         */
        if (end == node) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        if (null == head) {
            head = node;
            return;
        }

        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
            end = node;
        }
    }

    private String removeNode(Node node) {
        if (head == null && end == node) {
            head = null;
            end = null;
            return node.data;
        }

        if (head == node) {
            head = head.next;
            head.pre = null;
            return node.data;
        }

        if (end == node) {
            end = end.pre;
            end.next = null;
            return node.data;
        }

        /**
         * 删除node节点
         */
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node.data;
    }

    public static void main(String[] args) {
        LRUSimpleImp lruSimpleImp = new LRUSimpleImp(5);
        lruSimpleImp.put("001", "user1");
        lruSimpleImp.put("002", "user2");
        lruSimpleImp.put("003", "user3");
        lruSimpleImp.put("004", "user4");
        lruSimpleImp.put("005", "user5");

    }
}
