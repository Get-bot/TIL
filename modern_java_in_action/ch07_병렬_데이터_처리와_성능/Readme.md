# 7. 병렬 데이터 처리와 성능

- 자바7의 등장 이전에는 데이터 컬렉션을 병렬로 처리하기 어려웠다.
- 데이터를 서브파트로 분할하고 스레드로 할당하고 레이스 컨디션이 발생하지 않도록 적절한 동기화를 추가하며, 부분 결과를 합치는 과정을 거쳐야 했다.
- 자바7이 등장하며 병렬화를 수행하면서 에러를 최소화 할 수 있도록 **포크/조인 프레임워크** 기능을 제공한다.
- 스트림을 이용하면 순자 스트림을 병렬 스트림으로 자연스럽게 변경 가능하다.

# 병렬 스트림

- 컬렉션에 paralleStream을 호출하면 **병렬 스트림**이 생성된다.
- 병렬 스트림이란 각각의 스레드에서 처리할 수 있도록 스트림의 요소를 여러 청크로 분할한 스트림니이다.
- 병렬 스트림을 이용하면 모든 멀티코어 프로세서가 각각의 청크를 처리하도록 할당할 수 있다.

## 순차 스트림을 병렬 스트림으로 변환하기

```java
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
      .parallel() // 스트림을 병렬 스트림으로 변환
      .reduce(0L, Long::sum);
}
```

- 병렬 리듀싱 연산

  ![Untitled](./img/Untitled.png)

    - 순차 스트림에 parallel 메서드를 호출하면 기존의 함수형 리듀싱 연산 이 병렬로 처리된다.
    - 리듀싱 연산을 여러 청크에서 병렬로 실행
    - 리듀싱 연산으로 생성된 부분을 다시 리듀싱 연산으로 합쳐 전체 스트림의 리듀싱 결과 도출
- 순차 스트림에 parallel을 호출시 내부적으로 이후 연산이 병롤로 수행되되도록 불리언 플래그가 설정되며 sequential로 순차 스트림으로 설정 가능하다.
- parallel과 sequential 두 메서드 중 최종적으로 호출된 메서드가 전체 파이프라인에 영향을 미친다.

```java
stream.parallel()
			.filter()
			.sequential()
			.map()
			.parallel()
			.reduce();
```

- 스트림의 parallel 메서드에서 병렬 작업을 수행하는 스레드는 프로세서 수 값에 상응하는 스레드를 갖는다.

## 스트림 성능 측정

- 병렬화를 이용하면 순차나 반복 형식에 비해 성능이 좋아질 것이라 추측한다. 하지만 소프트웨어 공학에서 추측은 위험한 발상이다. 성능을 최적하할 때 세 가지 확금 규칙 측정, 측정, 측정을 기억하자
- JMH라이브러리를 이용해 벤치마크를 구현해 측정을 실시해보자
    - gradle

    ```java
    plugins {
        id "me.champeau.jmh" version "0.7.2"
    }
    ```

    - gradle jmh 으로 실행

```java
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
```

### 더 특화된 메서드 사용

- 병렬 프로그래밍은 까다롭고 때로는 이해하기 어려운 함정이 숨어있다. 심지어 병렬 프로그래밍을 오용하면 오히려 전체 프로그램의 성능이 더 나빠질 수 있다.

```java
public static long parallelSumOld(long n) {
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
```

- Old 코드
    - 반복 결과로 박싱된 객체가 만들어지므로 숫자를 더하려면 언박싱을 해야 한다.
    - 반복 작업은 병렬로 수행할 수 있는 독립 단위로 나누기가 어렵다.
    - 이전 연산의 결과에 따라 다음 함수의 입력이 달라지기 때문에 iterate 연산을 청크로 분할하기가 어렵다.
    - 리듀싱 과정을 시작하는 시점에 전체 숫자 리스트가 준비되지 않으므로 스트림을 병렬로 처리할 수 있도록 청크로 분할할 수 없다.
- 개선 코드
    - LongStream.rangeClosed는 기본형 long을 사용하므로 박싱과 오버헤드가 없다.
    - LongStream.rangeClosed는 쉽게 청크로 분할할 수 있는 숫자 범위를 생산한다.
    - 상황에 따라서 어떤 알고리즘을 병렬화하는 것보다 적적할 자료구조를 선택하는 것이 더 중요하다는 사실을 단적으로 보여준다.
- 공짜가 아닌 병렬화
    - 병렬화를 이용하려면 스트림을 재귀적으로 분할해야 하고,  각 서브스트림을 서로 다른 스레드의 리듀싱 연산으로 할당하고, 이 결과를 하나의 값으로 합쳐야 한다.
    - 멀티코어 간의 데이터 이동은 생각보다 비싸므로 코에 간에 데이터 전송 시간보다 훨씬 오래 걸리는 작업만 병렬 처리로 수행하는 것이 바람직하다.

## 병렬 스트림의 올바른 사용법

- 병렬 스트림을 잘못 사용하면서 발생하는 많은 문제는 공유된 상태를 바꾸는 알고리즘을 사용하기 때문에 일어난다.
- n 까지의 자연수를 더하면서 공유된 누적자를 바꾸는 프로그램

```java
public long sideEffectSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1, n).forEach(accumulator::add);
    return accumulator.total;
  }

public static class Accumulator {
  public long total = 0;
  public void add(long value) { total += value; }
}

//병렬 실행
public long sideEffectParallelSum(long n) {
  Accumulator accumulator = new Accumulator();
  LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
  return accumulator.total;
}
```

- 명령형 코드
    - 누적자를 초기화하고, 리스트의 각 요소를 하나씩 탐색하며 누적자에 숫자를 추가할 수 있다.
- 병렬 코드
    - 위 코드는 본질적으로 순차 실행할 수 있도록 구현되어 있으므로 병렬로 실행시 문제가 생긴다.
    - total을 접근할 때마다(다수의 스레드에서) 데이터 레이스 문제가 발생한다.
    - 동기화로 문제를 해결하려 하다보면 결국 병렬화라는 특성이 없어져 버린다.(대기)
    - 메서드의 성능도 좋지 않으며 올바른 결과값이 나오지 않는다. 여러 스레드에서 동시에 누적자(total += value)를 실행하면서 이런 문제가 발생한다.
    - 결국 여러 스레드에서 공유하는 객체의 상태를 바꾸는 forEach 블록 내부에서 add 메서드를 호출하면서 이 같은 문제가 발생한다
- 위와 같은 문제를 피하려면 병렬 스트림을 사용했을 때 상태 공유에 따른 부작용을 피해야 한다.
- 즉 공유된 가변 상태를 피해야 한다.

### 병렬 스트림 효과적으로 사용하기

1. 확신이 서지 않는다면 직접 측정하라.
2. 박싱을 주의하라.
3. 순차 스트림보다 병렬 스트림에서 성능이 떨어지는 연산이 있다.
4. 스트림에서 수행하는 전체 파이프라인 연산 비용을 고려하라.
5. 소량의 데이터에서는 병렬 스트림이 도움 되지 않는다.
6. 스트림을 구성하는 자료구조가 적절한지 확인하라.
7. 스트림의 특정과 파이프라인의 중간 연산이 스트림의 특성을 어떻게 바꾸는지에 따라 분해 과정의 성능이 달라질 수 있다.
8. 최종 연산의 병합 과정 비용을 살펴보라.
9. 병렬 스트림이 수행되는 내부 인프라구조를 살펴보라.(포크/조인 프레임워크)

## 포크/조인 프레임워크