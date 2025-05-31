package org.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Task019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur = head;
        if (head != null) size = 1;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        if (size == 1 && n == 1) return null;

        cur = head;
        ListNode left = null;
        ListNode right = null;
        for (int i = 0; i < size; i++) {
            if (i == size - n - 1) left = cur;
            if (i == size - n + 1) right = cur;
            cur = cur.next;
        }
        if (left == null) {
            return right;
        } else {
            left.next = right;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
