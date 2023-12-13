package ch13.sec03.exam01;

public class GenericExample {

  public static <T> Box<T> boxing(T t) {
    Box<T> box = new Box<T>();
    box.setT(t);
    return box;
  }

  public static void main(String[] args) {
    Box<Integer> integerBox = boxing(100);
    int intValue = integerBox.getT();
    System.out.println(intValue);

    Box<String> stringBox = boxing("홍길동");
    String strValue = stringBox.getT();
    System.out.println(strValue);

  }
}
