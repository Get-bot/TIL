package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
  public static void main(String[] args) {
    //List 컬렉션 생성
    List<String> list = new ArrayList<>();
    for(int i=0; i<1000; i++) {
      list.add("홍길동" + i);
    }

    //병렬 처리
    Stream<String> parallelStream = list.parallelStream(); // 병렬스트림 얻기
    parallelStream.forEach(ParallelStreamExample::print); // 요소 처리
  }

  private static void print(String s) {
    System.out.println(s + " : " + Thread.currentThread().getName());
  }
}
