package com.ac.algorithm.xiaohui;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * tree implement by recursion
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/4
 */
public class TreeDemo {

    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        if (CollectionUtils.isEmpty(linkedList)) {
            return null;
        }
        Integer data = linkedList.removeFirst();

        TreeNode node = null;
        if (null != data) {
            node = new TreeNode(data);
            node.left = createBinaryTree(linkedList);
            node.right = createBinaryTree(linkedList);
        }

        return node;
    }

    /**
     * traveral by pre-ordering
     */
    public static void preOrderTraveral(TreeNode node) {

        if (null == node) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);

    }

    /**
     * traveral by in-ordering
     *
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrderTraveral(node.left);
        System.out.println(node.data);
        inOrderTraveral(node.right);

    }


    public static void postOrderTraveral(TreeNode node) {
        if (null == node) {
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        TreeNode binaryTree = createBinaryTree(new LinkedList<>(Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, 4, null, null, 6, null, null)));
        System.out.println("前序遍历");
        preOrderTraveral(binaryTree);
        System.out.println("中序遍历");
        inOrderTraveral(binaryTree);
        System.out.println("后序遍历");
        postOrderTraveral(binaryTree);
    }
}
