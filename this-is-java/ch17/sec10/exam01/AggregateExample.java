package ch17.sec10.exam01;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class AggregateExample {
  public static void main(String[] args) {
    //정수 배열
    int[] arr = { 1, 2, 3, 4, 5 };

    //카운팅
    long count = Arrays.stream(arr)
        .filter(n -> n%2 == 0)
        .count();

    System.out.println("2의 배수 개수: " + count);

    //총합
    int sum = Arrays.stream(arr)
        .filter(n -> n%2 == 0)
        .sum();

    //평균
    OptionalDouble optionalAvg = Arrays.stream(arr)
        .filter(n -> n%2 == 0)
        .average();

    double avg = optionalAvg.isPresent() ? optionalAvg.getAsDouble() : 0.0;
    System.out.println("평균: " + avg);

    //최대값
    OptionalInt optionalMax = Arrays.stream(arr)
        .filter(n -> n%2 == 0)
        .max();

    int max = optionalMax.isPresent() ? optionalMax.getAsInt() : 0;
    System.out.println("최대값: " + max);

    //최소값
    OptionalInt optionalMin = Arrays.stream(arr)
        .filter(n -> n%2 == 0)
        .min();

    int min = optionalMin.isPresent() ? optionalMin.getAsInt() : 0;
    System.out.println("최소값: " + min);

    //첫 번째 요소
    OptionalInt optionalFirst = Arrays.stream(arr)
        .filter(n -> n%3 == 0)
        .findFirst();

    if(optionalFirst.isPresent()) {
      System.out.println("첫 번째 3의 배수: " + optionalFirst.getAsInt());
    } else {
      System.out.println("첫 번째 3의 배수가 없습니다.");
    }
  }
}
