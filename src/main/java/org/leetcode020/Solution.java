package org.leetcode020;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    private static boolean isValid(String s) {

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            System.out.println(cur);
            if (cur.equals("(")) {
                stack.add("(");
            } else if (cur.equals(")")) {
                if (stack.peek() != null && stack.peek().equals("(")) {
                    stack.remove();
                } else {
                    return false;
                }
            }
            if (cur.equals("[")) {
                stack.add("[");
            
            } else if (cur.equals("]")) {
                System.out.println(stack);
                if (stack.peek() != null && stack.peek().equals("[")) {
                    stack.remove();

                } else {
                    return false;
                }
            }
            if (cur.equals("{")) {
                stack.add("{");
            } else if (cur.equals("}")) {
                if (stack.peek() != null && stack.peek().equals("{")) {
                    stack.remove();
                } else {
                    return false;
                }
            }

        }
        System.out.println(stack);

        return stack.isEmpty();
    }
}
