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
class Task061 {
    public ListNode rotateRight(ListNode head, int k) {

        int size = 1;
        ListNode cur = head;
        ListNode last = new ListNode();
        ListNode rotated = new ListNode();

        if (head == null) return head;
        if (head.next == null) return head;

        while (cur.next != null) { //calculate size
            cur = cur.next;
            last = cur;
            size++;
        }

        int cnt = 0;
        if (k >= size) { //not need unnecessary steps
            cnt = k % size;
        } else {
            cnt = k;
        }

        cur = head;
        for (int i = 0; i < size - cnt - 1; i++) {
            cur = cur.next;
        }
        System.out.println(cur.val);

        //rotate list
        last.next = head;
        rotated = cur.next;
        cur.next = null;

        return rotated;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
