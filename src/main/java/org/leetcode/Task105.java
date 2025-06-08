package org.leetcode;

import java.util.HashMap;
import java.util.Map;

class Task105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Map<Integer, Integer> valNodeLeft = new HashMap<>();
        Map<Integer, Integer> valNodeRight = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            boolean right = false;
            if (i == 0) {
                root.val = preorder[i];
                nodes.put(root.val, root);
                right = false;
                for (int j = 0; j < inorder.length; j++) {
                    if (!right && preorder[i] == inorder[j]) right = true;
                    if (preorder[i] == inorder[j]) continue;
                    if (!right) valNodeLeft.put(inorder[j], preorder[i]);
                    if (right) valNodeRight.put(inorder[j], preorder[i]);
                }
            } else {
                right = false;
                for (int j = 0; j < inorder.length; j++) {
                    if (!right && preorder[i] == inorder[j]) right = true;
                    if (preorder[i] == inorder[j]) continue;

                    Integer key = inorder[j];
                    if (nodes.containsKey(key) && !right) continue;
                    if (nodes.containsKey(key) && right) break;

                    if (!right) {
                        valNodeRight.remove(key);
                        valNodeLeft.put(inorder[j], preorder[i]);
                    }
                    if (right) {
                        valNodeLeft.remove(key);
                        valNodeRight.put(inorder[j], preorder[i]);
                    }
                }
                nodes.put(preorder[i], new TreeNode(preorder[i]));
            }
        }

        for (Map.Entry<Integer, Integer> entry: valNodeLeft.entrySet()) {
            TreeNode node = nodes.get(entry.getValue());
            node.left = nodes.get(entry.getKey());
        }
        for (Map.Entry<Integer, Integer> entry: valNodeRight.entrySet()) {
            TreeNode node = nodes.get(entry.getValue());
            node.right = nodes.get(entry.getKey());
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
