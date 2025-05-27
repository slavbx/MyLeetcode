package org.leetcode012;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int num = 1994;
        String result = "";
        int[] digits = new int[13];
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "M"); // digits[0]
        numbers.put(1, "CM"); // digits[1]
        numbers.put(2, "D");  // digits[2]
        numbers.put(3, "CD"); // digits[3]
        numbers.put(4, "C");  // digits[4]
        numbers.put(5, "XC");  // digits[5]
        numbers.put(6, "L");   // digits[6]
        numbers.put(7, "XL");  // digits[7]
        numbers.put(8, "X");   // digits[8]
        numbers.put(9, "IX");   // digits[9]
        numbers.put(10, "V");    // digits[10]
        numbers.put(11, "IV");   // digits[11]
        numbers.put(12, "I");    // digits[12]

        int remainder = num;
        digits[0] = remainder / 1000; remainder = num - digits[0] * 1000;
        digits[1] = remainder / 900;

        if (digits[1] == 0) {
            if (remainder / 100 == 4) {
                digits[3] = 1;
            } else {
                digits[2] = remainder / 500;
                digits[4] = (remainder - digits[2] * 500) / 100;
            }
        }

        System.out.println("num900s = " + digits[1]);
        System.out.println("num1000s = " + digits[0]);
        System.out.println("num100s = " + digits[4]);
        System.out.println("num400s = " + digits[3]);
        System.out.println("num500s = " + digits[2]);

        remainder = remainder - (digits[1] * 900 + digits[2] * 500 + digits[3] * 400 + digits[4] * 100);
        System.out.println(remainder);

        digits[5] = remainder / 90;
        if (digits[5] == 0) {
            if (remainder / 10 == 4) {
                digits[7] = 1;
            } else {
                digits[6] = remainder / 50;
                digits[8] = (remainder - digits[6] * 50) / 10;
            }
        }

        System.out.println("num10s = " + digits[8]);
        System.out.println("num40s = " + digits[7]);
        System.out.println("num50s = " + digits[6]);
        System.out.println("num90s = " + digits[5]);

        remainder = remainder - (digits[5] * 90 + digits[6] * 50 + digits[7] * 40 + digits[8] * 10);
        System.out.println(remainder);

        digits[9] = remainder / 9;
        if (digits[9] == 0) {
            if (remainder == 4) {
                digits[11] = 1;
            } else {
                digits[10] = remainder / 5;
                digits[12] = remainder - digits[10] * 5;
            }
        }

        System.out.println("num1s = " + digits[12]);
        System.out.println("num4s = " + digits[11]);
        System.out.println("num5s = " + digits[10]);
        System.out.println("num9s = " + digits[9]);

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i]; j++) {
                result = result + numbers.get(i);
            }
        }

        System.out.println(result);
    }
}
