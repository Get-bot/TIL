package ch07_병렬_데이터_처리와_성능.jhm;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime) // 벤치마크 대상 메서드 실행하는 데 걸린 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 벤치마크 결과를 밀리초 단위로 출력
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) // 2회 측정하고 각 측정 결과를 평균내어 반환
public class ParallelStreamBenchmark {
  private static final long N = 10_000_000L; // 1000만

  @Benchmark // 벤치마크 대상 메서드
  public long sequentialSum() {
    return Stream.iterate(1L, i -> i + 1)
        .limit(N)
        .reduce(0L, Long::sum);
  }

  @TearDown(Level.Invocation) // 각 벤치마크 실행 후에 실행되는 메서드
  public void tearDown() {
    System.gc(); // 가비지 컬렉터 실행
  }
}
