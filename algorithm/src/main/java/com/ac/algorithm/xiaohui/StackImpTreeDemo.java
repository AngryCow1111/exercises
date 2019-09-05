package com.ac.algorithm.xiaohui;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/4
 */
public class StackImpTreeDemo {
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
     * 前序遍历
     *
     * @param root
     */
    public static void preOrderTraveral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (null != treeNode || !stack.isEmpty()) {
            while (null != treeNode) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }


    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrderTraveral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            while (null != treeNode) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.right;
            }
        }

    }

    //TODO
    public static void postOrderTraveral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> outputStack = new Stack<>();
        TreeNode treeNode = root;
        int sign = 0;
        while (treeNode != null || !stack.isEmpty()) {
            if (null != treeNode) {
                stack.push(treeNode);
                outputStack.push(treeNode);
                treeNode = treeNode.right;
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.left;
            }
        }
        for (; !outputStack.isEmpty(); ) {
            TreeNode pop = outputStack.pop();
            System.out.println(pop.data);
        }


    }

    public static void main(String[] args) {
        TreeNode binaryTree = createBinaryTree(
                new LinkedList<>(Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, 4, null, null, 6, null, null)));
        System.out.println("前序遍历");
        preOrderTraveral(binaryTree);

        System.out.println("中序遍历");
        inOrderTraveral(binaryTree);

        System.out.println("后序遍历");
        postOrderTraveral(binaryTree);
    }
}
