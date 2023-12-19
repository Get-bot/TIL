package ch07_병렬_데이터_처리와_성능;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class RecursiveTask {
  public static void main(String[] args) {
    System.out.println("forkJoinSum = " + forkJoinSum(100000000));
  }

  public static long forkJoinSum(long n) {
    long[] numbers = LongStream.rangeClosed(1, n).toArray();
    ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
    return new ForkJoinPool().invoke(task);
  }
}
