package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        //문자 스트림을 단어 스트림으로 변환
        List<String> list1 = new ArrayList<>();
        list1.add("java8 lambda");
        list1.add("stream mapping");

        Stream<String> stringStream = list1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")));

        stringStream.forEach(System.out::println);

        //문자열 숫자 목록 스트림을 숫자 스트림으로 변환
        List<String> list2 = new ArrayList<>();
        list2.add("10, 20, 30");
        list2.add("40, 50, 60");

        list2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for(int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(System.out::println);
    }
}
