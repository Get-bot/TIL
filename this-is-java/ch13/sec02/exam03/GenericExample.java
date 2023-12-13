package ch13.sec02.exam03;

public class GenericExample {
  public static void main(String[] args) {
    Box box1 = new Box();
    box1.content = "홍길동";

    Box box2 = new Box();
    box2.content = "홍길동";

    boolean result = box1.compare(box2);

    System.out.println(result);

    Box box3 = new Box();
    box3.content = "1";

    Box box4 = new Box();
    box4.content = 1;

    boolean result2 = box3.compare(box4);

    System.out.println(result2);
  }
}
