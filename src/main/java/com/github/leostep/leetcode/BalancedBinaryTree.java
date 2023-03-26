package com.github.leostep.leetcode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balancedHeight(root) >= 0;
    }

    private int balancedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balancedHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = balancedHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        boolean isBalanced = Math.abs(leftHeight - rightHeight) <= 1;
        return isBalanced ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
