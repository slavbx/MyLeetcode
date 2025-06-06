package org.leetcode;

class Task112 {
    boolean result;
    int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if (root == null) return false;
        recursive(root, 0);
        return result;
    }

    public TreeNode recursive(TreeNode root, int sum) {
        if (root != null) {
            sum = sum + root.val;
            if (root.left == null && root.right == null && sum == this.targetSum) result = true;
            recursive(root.left, sum);
            recursive(root.right, sum);
        }
        return root;
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
