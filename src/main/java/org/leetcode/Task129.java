package org.leetcode;

import java.util.ArrayList;
import java.util.List;

class Task129 {
    List<Integer> sums = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        recursive(root, "");
        return sums.stream().mapToInt(Integer::intValue).sum();
    }

    public TreeNode recursive(TreeNode root, String path) {
        if (root != null) {
            path = path + root.val;
            if (root.left == null && root.right == null) {
                sums.add(Integer.parseInt(path));
            }
            recursive(root.left, path);
            recursive(root.right, path);
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
