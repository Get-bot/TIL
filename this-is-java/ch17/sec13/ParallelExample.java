package ch17.sec13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
  public static void main(String[] args) {
    Random random = new Random();

    List<Integer> scores = new ArrayList<>();
    for(int i = 0; i < 100000000; i++) {
      scores.add(random.nextInt(100));
    }

    double avg;
    long start;
    long end;
    long time;

    Stream<Integer> stream = scores.stream();
    start = System.nanoTime();
    avg = stream
        .mapToInt(Integer::intValue)
        .average().orElse(0.0);
    end = System.nanoTime();
    time = end - start;
    System.out.println("순차 처리 시간: " + time);

    stream = scores.parallelStream();
    start = System.nanoTime();
    avg = stream
        .mapToInt(Integer::intValue)
        .average().orElse(0.0);
    end = System.nanoTime();
    time = end - start;
    System.out.println("병렬 처리 시간: " + time);
  }

  //4,2,4,3,
}
