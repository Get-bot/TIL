package ch07_병렬_데이터_처리와_성능;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class parallelStream {
  public static void main(String[] args) {
    long sequentialSum = sequentialSum(100);
    System.out.println("sequentialSum = " + sequentialSum);

    long parallelSum = parallelSum(100);
    System.out.println("parallelSum = " + parallelSum);

  }

  //순차 스트림
  public static long sequentialSum(long n) {
    return Stream.iterate(1L, i -> i + 1)
        .limit(n)
        .reduce(0L, Long::sum);
  }

  //반복문
  public static long iterativeSum(long n) {
    long result = 0;
    for (long i = 1L; i <= n; i++) {
      result += i;
    }
    return result;
  }

  //병렬 스트림
  public static long parallelSum(long n) {
    return Stream.iterate(1L, i -> i + 1)
        .limit(n)
        .parallel()
        .reduce(0L, Long::sum);
  }

  //병렬 스트림 개선
  public static long parallelRangedSum(long n) {
    return LongStream.rangeClosed(1, n)
        .parallel()
        .reduce(0L, Long::sum);
  }

  public long sideEffectSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1, n).forEach(accumulator::add);
    return accumulator.total;
  }

  public long sideEffectParallelSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
    return accumulator.total;
  }

  public static class Accumulator {
    public long total = 0;
    public void add(long value) { total += value; }
  }
}
