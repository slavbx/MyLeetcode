package org.leetcode;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Task138 {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> oldNodes = new HashMap<>();
        Map<Integer, Node> newNodes = new HashMap<>();

        Node cur = head;
        int num = 0;
        if (head != null) {
            while (true) {
                oldNodes.put(cur, num);
                newNodes.put(num++, new Node(cur.val));
                if (cur.next != null) {
                    cur = cur.next;
                } else {
                    break;
                }
            }
        }

        cur = head;
        for (int i = 0; i < num; i++) {
            cur = newNodes.get(i);
            cur.next = newNodes.get(oldNodes.get(head.next));
            cur.random = newNodes.get(oldNodes.get(head.random));
            head = head.next;
        }
        return newNodes.get(0);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
