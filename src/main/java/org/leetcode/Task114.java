package org.leetcode;

import java.util.ArrayList;
import java.util.List;

class Task114 {
    TreeNode cur;
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root != null) {
            cur = new TreeNode(root.val, null, null);
            recursive(root, 0);
            for(TreeNode n: list) {
                root.right = n;
                root.left = null;
                root = root.right;
            }
        }
    }

    public TreeNode recursive(TreeNode root, int floor) {
        floor++;
        if (root != null) {
            if (floor > 1) {
                cur.right = new TreeNode(root.val, null, null);
                cur = cur.right;
                list.add(cur);
            }
            recursive(root.left, floor);
            recursive(root.right, floor);
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
