package org.leetcode;

import java.util.HashSet;
import java.util.Set;


class Task104 {
    private Set<Integer> floors = new HashSet<>();

    public int maxDepth(TreeNode root) {
        if (root != null) {
            saveFloors(root, 0);
            return floors.size();
        }
        return 0;
    }

    private void saveFloors(TreeNode node, int floor) {
        floors.add(++floor);
        if (node.left != null) {
            saveFloors(node.left, floor);
        }
        if (node.right != null) {
            saveFloors(node.right, floor);
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
