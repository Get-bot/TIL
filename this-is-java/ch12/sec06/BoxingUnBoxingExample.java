package ch12.sec06;

public class BoxingUnBoxingExample {
  public static void main(String[] args) {
    // Boxing
    Integer obj = 100;
    System.out.println("value: " + obj);

    // Unboxing
    int value = obj;
    System.out.println("value: " + value);

    // Auto Boxing
    Integer obj2 = 100;
    System.out.println("value: " + obj2);
  }
}
