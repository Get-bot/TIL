package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6, 8, 10};

        IntStream intStream = IntStream.of(intArr);

        intStream
                .filter(n -> n % 3 == 0)
                .forEach(System.out::println);

        intStream = Arrays.stream(intArr);

        intStream
                .asDoubleStream()
                .forEach(System.out::println);

        intStream = Arrays.stream(intArr);
        intStream
                .boxed()
                .forEach(System.out::println);
    }
}
