package org.example;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

//public class Main {
//    public static void main(String[] args) {
//        printNums();
//    }
//
//    public static void printNums() {
//        IntPredicate predicate = new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                int sum = Arrays.stream(String.valueOf(value).split(""))
//                        .mapToInt(Integer::parseInt)
//                        .reduce(Integer::sum).orElse(0);
//                return sum < 10;
//            }
//        };
//
//        IntStream.range(0, 1000)
//                .filter(n -> n % 3 == 0)
//                .filter(n -> n % 5 != 0)
//                .filter(predicate)
//                .forEach(n -> System.out.print(n + " "));
//
//    }
//}

public class Main {
    public static void main(String[] args) {
        printNums();
    }

    public static void printNums() {
        IntPredicate predicate = value -> {
            int sum = 0;
            int num = value;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum < 10;
        };

        IntStream.range(0, 1000)
                .filter(n -> n % 3 == 0)
                .filter(n -> n % 5 != 0)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}