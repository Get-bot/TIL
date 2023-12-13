package ch16.sec05.exam02;

public class Person {
  public void ordering(Comparable comparable) {
    String a = "홍길동";
    String b = "김자바";

    int result = comparable.compare("a", "b");

    if(result < 0) {
      System.out.println(a + "가 먼저옵니다.");
    } else if(result == 0) {
      System.out.println("동일한 문자열입니다.");
    } else {
      System.out.println(b + "가 먼저옵니다.");
    }
  }
}
