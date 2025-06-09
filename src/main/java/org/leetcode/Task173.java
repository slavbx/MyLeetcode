package org.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class Task173 {
    TreeNode root;
    int counter;
    int pointer;
    Deque<Integer> stack = new ArrayDeque<>();

    public Task173(TreeNode root) {
        this.root = root;
        recursiveInit(this.root);
    }

    public int next() {
        pointer++;
        return stack.removeLast();
    }

    public boolean hasNext() {
        return pointer < counter;
    }

    private void recursiveInit(TreeNode root) {
        if (root != null) {
            counter++;
            recursiveInit(root.left);
            stack.push(root.val);
            recursiveInit(root.right);
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
