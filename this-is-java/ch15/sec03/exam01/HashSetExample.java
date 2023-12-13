package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
  public static void main(String[] args) {
    // HashSet 컬렉션 생성
    Set<String> set = new HashSet<String>();

    // 객체 저장
    set.add("Java");
    set.add("JDBC");
    set.add("Servlet/JSP");
    set.add("Java"); // 동일한 객체이므로 저장되지 않음
    set.add("iBATIS");

    int size = set.size(); // 저장된 객체 수 얻기

    System.out.println("총 객체수: " + size);

  }
}
