package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Copy solution from Task116
class Task117 {
    Map<Integer, List<Node>> map = new HashMap<>();

    public Node connect(Node root) {
        if (root == null) return null;
        fillMapRecursive(root, 0);
        for (Map.Entry<Integer, List<Node>> e: map.entrySet()) {
            List<Node> list = e.getValue();
            for(int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    Node node = list.get(i);
                    node.next = list.get(i + 1);
                }
            }
        }
        return root;
    }

    public Node fillMapRecursive(Node root, int floor) {

        if (root != null) {
            floor++;
            if (!map.containsKey(floor)) {
                map.put(floor, new ArrayList<>());
            }
            map.get(floor).add(root);

            fillMapRecursive(root.left, floor);
            fillMapRecursive(root.right, floor);
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
