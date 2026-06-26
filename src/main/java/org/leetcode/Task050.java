package org.leetcode;

//50. Pow(x, n)
public class Task050 {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
        System.out.println(myPow(2, 2000000));
        System.out.println(myPow(2.10000, 3));
    }


    public static double myPow(double x, int n) {
        if (n > 0) {
            return recursive(x, n);
        } else {
            return 1 / recursive(x, Math.abs(n));
        }

    }

    //чтобы в два раза быстрее посчитать большую степень числа нужно разложить ее как произведение полустепеней этого числа
    //2^11 = 2^5 * 2^5 * 2
    public static double recursive(double value, int pow) {
        if (pow == 0) return 1;
        if (pow == 1) return value;

        double half = recursive(value, pow / 2);
        if (pow % 2 == 0) {
            return half * half;
        } else {
            return half * half * value;
        }
    }
}
