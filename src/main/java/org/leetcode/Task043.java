package org.leetcode;

import java.util.Arrays;

//43. Multiply Strings
public class Task043 {
    public static void main(String[] args) {
        System.out.println(multiply("124","21"));
    }

    public static String multiply(String num1, String num2) {
        int num11 = getInt(num1);
        int num21 = getInt(num2);
        int digit = 0;
        return String.valueOf(num11 * num21);
    }

    public static int getInt(String num) {
        int intNum = 0;
        int digit = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            intNum = intNum + (num.charAt(i) - 48) * (int) Math.pow(10, digit);
            digit++;
        }
        return intNum;
    }

}
