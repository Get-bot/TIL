package ch15.sec07;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
  public static void main(String[] args) {
    // synchronizedMap 컬렉션 생성
     Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

     //스레드
    Thread threadA = new Thread(() -> {
      for(int i=0; i<1000; i++) {
        map.put("A" + i, i);
      }
    });

    Thread threadB = new Thread(() -> {
      for(int i=0; i<1000; i++) {
        map.put("B" + i, i);
      }
    });

    threadA.start();
    threadB.start();


    try {
      threadA.join();
      threadB.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("map.size(): " + map.size());
  }
}
