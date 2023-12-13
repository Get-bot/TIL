package ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
  public static void main(String[] args) {
    // HashSet 컬렉션 생성
    Set<Member> set = new HashSet<Member>();

    // 객체 저장
    set.add(new Member("홍길동", 30));
    set.add(new Member("홍길동", 30));

    int size = set.size(); // 저장된 객체 수 얻기

    System.out.println("총 객체수: " + size);
  }
}
