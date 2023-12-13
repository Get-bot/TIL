package ch17.sec10.exam02;

import java.util.List;
import java.util.ArrayList;
import java.util.OptionalDouble;

public class OptionalExample {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    OptionalDouble optionalAvg = list.stream()
      .mapToInt(Integer::intValue)
      .average();

    if(optionalAvg.isPresent()) {
      System.out.println("평균: " + optionalAvg.getAsDouble());
    } else {
      System.out.println("평균: 0.0");
    }

    double avg = list.stream()
      .mapToInt(Integer::intValue)
      .average()
      .orElse(0.0);

    System.out.println("평균: " + avg);

    list.stream()
      .mapToInt(Integer::intValue)
      .average()
      .ifPresent(a -> System.out.println("평균: " + a));
  }
}
