package org.example;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main2 {
    public static void main(String[] args) {
        sumDigits();
    }

    public static void sumDigits() {
        IntPredicate predicate = value -> {
            int sum = 0;
            while (value > 0) {
                sum = sum + value % 10;
                value = value / 10;
            }
            return sum < 10;
        };


        IntStream.rangeClosed(0, 1000)
                .filter(n -> n % 3 == 0)
                .filter(n -> n % 5 != 0)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
