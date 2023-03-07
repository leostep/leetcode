package com.github.leostep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swap(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val,
                 TreeNode left,
                 TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
