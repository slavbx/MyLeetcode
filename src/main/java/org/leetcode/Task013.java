package org.leetcode013;

import java.util.HashMap;
import java.util.Map;

public class Task013 {


    public static void main(String[] args) {
        String s = "LVIII";

        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("I", 1);
        numbers.put("V", 5);
        numbers.put("X", 10);
        numbers.put("L", 50);
        numbers.put("C", 100);
        numbers.put("D", 500);
        numbers.put("M", 1000);

        String prev = "";
        Integer sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            String symbol = String.valueOf(s.charAt(i));
            if ((prev.equals("V") || prev.equals("X")) && symbol.equals("I")) {
                System.out.println("Отнимаем " + 1);
                sum = sum - 1;
                prev = "";
            } else if ((prev.equals("L") || prev.equals("C")) && symbol.equals("X")) {
                System.out.println("Отнимаем " + 10);
                sum = sum - 10;
                prev = symbol;
            } else if ((prev.equals("D") || prev.equals("M")) && symbol.equals("C")) {
                System.out.println("Отнимаем " + 100);
                sum = sum - 100;
                prev = symbol;
            } else {

                sum = sum + numbers.get(symbol);
                prev = symbol;
                System.out.println("Сума " + sum);
            }
        }
        System.out.println("sum = " + sum);
    }
}
