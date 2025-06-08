package org.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.SortedSet;
import java.util.TreeSet;

class Task155 {
    Deque<Integer> stack;
    SortedSet<Integer> min;

    public Task155() {
        this.stack = new ArrayDeque<>();
        this.min = new TreeSet<>();
    }

    public void push(int val) {
        stack.push(val);
        min.add(val);
    }

    public void pop() {
        Integer num = stack.pop();
        if (!stack.contains(num)) min.remove(num);
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        if (!min.isEmpty()) return min.first();
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
