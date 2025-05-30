package org.leetcode;

import java.util.ArrayList;
import java.util.List;

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
class Task092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> values = new ArrayList<>();
        List<Integer> newValues = new ArrayList<>();
        values.add(head.val);
        while (head.next != null) {
            head = head.next;
            values.add(head.val);
        }

        int invCursor = right - 1;
        for (int i = 0; i < values.size(); i++) {
            if (i < left - 1) { //start
                newValues.add(values.get(i));
            } else if (i > right - 1) { //end
                newValues.add(values.get(i));
            } else { //median
                newValues.add(values.get(invCursor));
                invCursor--;
            }
        }

        ListNode cur = new ListNode(newValues.get(newValues.size() - 1));
        for (int i = newValues.size() - 1; i > 0; i--) {
            ListNode next = new ListNode(newValues.get(i - 1));
            System.out.print(next.val + " ");
            next.next = cur;
            cur = next;
        }

        return cur;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
