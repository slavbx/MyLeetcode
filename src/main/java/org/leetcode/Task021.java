package org.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
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
class Task021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = list1;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        cur = list2;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        list.sort(Comparator.reverseOrder());

        if (!list.isEmpty()) {
            cur = new ListNode(0);
        } else {
            cur = null;
        }
        ListNode next;
        for (int i = 0; i < list.size(); i++) {
            cur.val = list.get(i);

            if (i < list.size() - 1) {
                next = new ListNode(0);
                next.next = cur;
                cur = next;
            }
        }
        return cur;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
