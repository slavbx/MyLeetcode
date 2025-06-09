package org.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

//236. Lowest Common Ancestor of a Binary Tree
class Task236 {
    Deque<Integer> pStack = new ArrayDeque<>();
    Deque<Integer> qStack = new ArrayDeque<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recursive(root, p, pStack);
        recursive(root, q, qStack);

        //cut greater stack to equal paths for find the lowest common ancestor
        if(pStack.size() < qStack.size()) {
            int steps = qStack.size() - pStack.size();
            for (int i = 0; i < steps; i++) {
                qStack.pop();
            }
        }
        if(pStack.size() > qStack.size()) {
            int steps = pStack.size() - qStack.size();
            for (int i = 0; i < steps; i++) {
                pStack.pop();
            }
        }
        if (pStack.peek().equals(qStack.peek())) return new TreeNode(pStack.peek());
        while (!Objects.equals(pStack.peek(), qStack.peek())) {
            pStack.pop();
            qStack.pop();
        }

        return new TreeNode(pStack.peek());
    }

    private boolean recursive(TreeNode root, TreeNode finded, Deque<Integer> stack) {
        if (root == null) return false;
        stack.push(root.val);
        if (root.val == finded.val) {  //fix found path in stack and protect it when return in recurse
            return true;
        }
        if (recursive(root.left, finded, stack) || recursive(root.right, finded, stack)) return true;
        stack.pop();
        return false;
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
