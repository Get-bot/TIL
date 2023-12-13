package ch12.sec11.exam03;

public class GetResourceExample {
  public static void main(String[] args) {
    Class clazz = Car.class;

    System.out.println(clazz.getResource("car.png").getPath());
    System.out.println(clazz.getResource("car.png").getFile());
  }
}
