package ch07_병렬_데이터_처리와_성능;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> { // RecursiveTask를 상속받아 포크/조인 프레임워크를 사용하는 태스크 정의
  private final long[] numbers; // 더할 숫자 배열
  private final int start; // 이 서브태스크에서 처리할 배열의 초기 위치와 최종 위치
  private final int end;
  private static final long THRESHOLD = 10_000; // 이 값 이하의 서브태스크는 더 이상 분할할 수 없음

  public ForkJoinSumCalculator(long[] numbers) { // 메인 태스크를 생성할 때 사용할 공개 생성자
    this(numbers, 0, numbers.length);
  }

  private ForkJoinSumCalculator(long[] numbers, int start, int end) { // 메인 태스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() { // RecursiveTask의 추상 메서드 오버라이드
    int length = end - start; // 이 태스크에서 더할 배열의 길이
    if (length <= THRESHOLD) {
      return computeSequentially(); // 기준 값과 같거나 작으면 순차적으로 결과를 계산
    }
    ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2); // 배열의 첫 번째 절반을 더하도록 서브태스크를 생성
    leftTask.fork();
    ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end); // ForkJoinPool의 다른 스레드로 새로 생성한 태스크를 비동기로 실행
    Long rightResult = rightTask.compute(); // 두 번째 절반을 더하도록 두 번째 서브태스크를 동기 실행
    Long leftResult = leftTask.join(); // 첫 번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다림
    return leftResult + rightResult; // 두 서브태스크의 결과를 조합한 값이 이 태스크의 결과
  }

  private long computeSequentially() { // 더 분할할 수 없을 때 서브태스크의 결과를 계산하는 단순한 알고리즘
    long sum = 0;
    for (int i = start; i < end; i++) {
      sum += numbers[i];
    }
    return sum;
  }

}
