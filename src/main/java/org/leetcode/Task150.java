package org.leetcode;

import java.util.ArrayDeque;

public class Task150 {
    public static void main(String[] args) {
        //String[] tokens = new String[] {"2","1","+","3","*"};
        //String[] tokens = new String[] {"3","11","+","5","-"};
        //String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};//22
        String[] tokens = new String[] {"4","13","5","/","+"};//6
        ArrayDeque<String> deque = new ArrayDeque<>();


        boolean start = true;
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("[+\\-*/]")) {
                deque.addLast(tokens[i]);
            } else {
                int val1 = Integer.parseInt(deque.removeLast());
                int val2 = Integer.parseInt(deque.removeLast());
                if (tokens[i].equals("+")) {
                    deque.addLast(String.valueOf(val2 + val1));
                } else if (tokens[i].equals("-")) {
                    deque.addLast(String.valueOf(val2 - val1));
                } else if (tokens[i].equals("*")) {
                    deque.addLast(String.valueOf(val2 * val1));
                } else if (tokens[i].equals("/")) {
                    deque.addLast(String.valueOf(val2 / val1));
                }
            }
        }
        System.out.println(deque.removeLast());
    }
}
