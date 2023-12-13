package ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 6, 5, 7, 8, 9, 4 };

        //잘못 작성한 경우
        Arrays.stream(arr)
                .filter(a -> a%2 == 0)
                .peek(n -> System.out.println(n)); // 동작하지 않음

        //올바르게 작성한 경우
        Arrays.stream(arr)
                .filter(a -> a%2 == 0)
                .peek(n -> System.out.println(n))
                .count(); // 동작함

        int sum = Arrays.stream(arr)
                .filter(a -> a%2 == 0)
                .peek(n -> System.out.println(n))
                .sum(); // 동작함

        System.out.println("sum: " + sum);
    }
}
