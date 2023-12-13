package ch15.sec04.exam02;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
  public static void main(String[] args) {
    //Hashtable 컬렉션 생성
    Map<String, Integer> map = new Hashtable<>();

    //작업 스레드 객체 생성
    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < 10000; i++) {
        map.put("A" + i, i);
      }
    });

    Thread thread2 = new Thread(() -> {
      for(int i = 0; i < 10000; i++) {
        map.put("B" + i, i);
      }
    });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("총 Entry 수: " + map.size());

  }
}
