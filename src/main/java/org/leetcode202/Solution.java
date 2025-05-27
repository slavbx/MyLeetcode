package org.leetcode202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        boolean result = false;
        Set<Integer> set = new HashSet<>();


        int cnt = 0;
        int sumOfSquares = 0;
        while (n != 1 && n < 2000) {
            if (set.contains(n)) cnt++;
            if (cnt > 20) break;
            String s = String.valueOf(n);
            String[] arr = s.split("");
            for (int i = 0; i < arr.length; i++) {
                sumOfSquares += Integer.parseInt(arr[i]) * Integer.parseInt(arr[i]);
            }
            System.out.println(sumOfSquares);
            n = sumOfSquares;
            set.add(n);
            sumOfSquares = 0;

        }
    }
}
