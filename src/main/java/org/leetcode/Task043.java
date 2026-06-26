package org.leetcode;

import java.math.BigDecimal;

//43. Multiply Strings
public class Task043 {
    public static void main(String[] args) {
        System.out.println(multiply("-2","21"));
        System.out.println(multiply("123456789","987654321"));
    }

    public static String multiply(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return (dec1.multiply(dec2)).toPlainString();
    }

}
