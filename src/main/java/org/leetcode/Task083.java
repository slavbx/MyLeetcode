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
class Task083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode left = null;
        ListNode right = null;
        if (head == null) return null;
        if (head.next == null) return head;
        left = head;
        right = head.next;

        while (right != null) {
            while (right != null && left.val == right.val) { //duplicate in start of list
                if (right.next == null) {
                    return null;
                } else if (left.val != right.next.val) {
                    head = right.next;
                    left = head;
                    right = head.next;
                    //break;
                } else {
                    right = right.next;
                }
            }
            if (right == null) return head;
            if (right.next == null) return head;

            right = right.next;

            while (left.next.val != right.val) { //search of duplicate
                if (right.next == null) {
                    return head;
                }
                right = right.next;
                left = left.next;
            }

            while (left.next.val == right.val) { //get all duplicate
                right = right.next;
                if (right == null) break;
            }
            left.next = right;

        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
