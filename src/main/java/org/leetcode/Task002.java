package org.leetcode;

import java.math.BigInteger;
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
class Task002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder first = new StringBuilder();
        ListNode cur = l1;
        while (cur != null) {
            first.append(cur.val);
            cur = cur.next;
        }
        first.reverse();
        System.out.println(first);

        StringBuilder second = new StringBuilder();
        cur = l2;
        while (cur != null) {
            second.append(cur.val);
            cur = cur.next;
        }
        second.reverse();
        System.out.println(second);

        BigInteger firstBig = new BigInteger(first.toString());
        BigInteger secondBig = new BigInteger(second.toString());
        BigInteger sumBig = firstBig.add(secondBig);

        String sum = String.valueOf(sumBig);

        String[] strArrThree = sum.toString().split("");

        ListNode result = new ListNode(0);
        ListNode next = new ListNode(0);

        cur = new ListNode(0);

        for (int i = 0; i < strArrThree.length; i++) {
            cur.val = Integer.parseInt(strArrThree[i]);

            if (i < strArrThree.length - 1) {
                next = new ListNode(0);
                next.next = cur;
                cur = next;
            }
        }
        System.out.println(sum);
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
