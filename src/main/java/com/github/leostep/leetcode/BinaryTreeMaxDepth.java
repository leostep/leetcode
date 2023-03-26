package com.github.leostep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : heightIterative(root);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int heightIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                height++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }
}
