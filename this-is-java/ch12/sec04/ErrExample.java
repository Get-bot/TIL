package ch12.sec04;

public class ErrExample {
  public static void main(String[] args) {
    try {
      int value = Integer.parseInt("1oo");
    } catch (NumberFormatException error) {
      System.out.println("에러 메시지: " + error.getMessage());
      error.printStackTrace();
    }
  }
}
