package org.leetcode;

import java.util.Scanner;

public class Task070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = 0;
        int one = 0;
        int two = 1;
        for (int i = 1; i <= n; i++) {
            temp = one + two;
            one = two;
            two = temp;
            System.out.println(one + ", " + two);
        }
    }
}