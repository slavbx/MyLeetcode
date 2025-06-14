package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//148. Sort List
class Task148 {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        if (head == null) return null;
        //Here I build list of nodes, sort it, rebuild and put it to head link
        while (cur.next != null) {
            list.add(cur);
            cur = cur.next;
        }
        list.add(cur);

        list.sort((node1, node2) -> Integer.compare(node1.val, node2.val));

        list.get(list.size() - 1).next = null;
        for(int i = list.size() - 1; i >= 0; i--) {
            if (i > 0) {
                list.get(i - 1).next = list.get(i);
            } else {
                head = list.get(i);
            }
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
