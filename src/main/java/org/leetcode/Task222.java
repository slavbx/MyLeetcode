package org.leetcode;

class Task222 {
    int counter;

    public int countNodes(TreeNode root) {
        recursive(root);
        return counter;
    }
    private void recursive(TreeNode root) {
        if (root != null) {
            counter++;
            recursive(root.left);
            recursive(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
