package com.github.leostep.leetcode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smaller = p.val <= q.val ? p : q;
        TreeNode larger = p.val > q.val ? p : q;
        if (smaller.val <= root.val && larger.val >= root.val) {
            return root;
        }
        if (smaller.val < root.val) {
            return lowestCommonAncestor(root.left, smaller ,larger);
        }
        return lowestCommonAncestor(root.right, smaller, larger);
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smaller = p.val <= q.val ? p : q;
        TreeNode larger = p.val > q.val ? p : q;
        while (root != null) {
            if (root.val > larger.val) {
                root = root.left;
            } else if (root.val < smaller.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
