package org.leetcode;

import java.util.ArrayList;

class Task086 {
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        if (head.next == null) return head;

        ArrayList<ListNode> smalls = new ArrayList<>();
        ArrayList<ListNode> others = new ArrayList<>();
        ListNode cur = head;
        ListNode small;
        ListNode other = null;
        ListNode prev = null;

        while (cur != null) {
            if (cur.val < x) {
                smalls.add(cur);
            } else {
                others.add(cur);
            }
            cur = cur.next;
        }

        if (!others.isEmpty()) {
            prev = others.get(others.size() - 1);
            prev.next = null;

            for (int i = others.size() - 2; i >= 0; i--) {
                other = others.get(i);
                other.next = prev;
                prev = other;
            }
        }
        other = prev;

        if (!smalls.isEmpty()) {
            prev = smalls.get(smalls.size() - 1);
            prev.next = other;

            for (int i = smalls.size() - 2; i >= 0; i--) {
                small = smalls.get(i);
                small.next = prev;
                prev = small;
            }
        }
        small = prev;

        return small;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}