package ch08_컬렉션_API_개선;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
  public static void main(String[] args) {
    //리듀스와 검색
    ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
    map.put("word1", 1L);
    map.put("word2", 2L);
    map.put("word3", 3L);

    long parallelismThreshold = 1;
    Optional<Long> maxValue = Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));

    System.out.println("maxValue = " + maxValue.get());



  }
}
