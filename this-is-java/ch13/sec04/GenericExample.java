package ch13.sec04;

public class GenericExample {

  public static <T extends Number> boolean compare(T t1, T t2) {

    System.out.println(t1.getClass().getName());
    System.out.println(t2.getClass().getName());

    double v1 = t1.doubleValue();
    double v2 = t2.doubleValue();

    return v1 == v2;
  }
  public static void main(String[] args) {
    boolean result = compare(1, 1.0);

    System.out.println(result);

    boolean result2 = compare(1, 2);

    System.out.println(result2);

    boolean result3 = compare(1.0, 1.0);

    System.out.println(result3);
  }
}
