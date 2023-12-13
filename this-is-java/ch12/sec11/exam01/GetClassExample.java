package ch12.sec11.exam01;

public class GetClassExample {
  public static void main(String[] args) throws ClassNotFoundException {
    Class<Car> clazz = Car.class;

    Class<?> clazz2 = Class.forName("ch12.sec11.exam01.Car");

    Car car = new Car();
    Class<?> clazz3 = car.getClass();

    System.out.println(clazz.getName());
    System.out.println(clazz2.getName());
    System.out.println(clazz3.getName());

    System.out.println(clazz == clazz2);
    System.out.println(clazz == clazz3);

    System.out.println("clazz.get = " + clazz.getPackage().getName());
    System.out.println("clazz.getSimpleName() = " + clazz.getSimpleName());
    System.out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());
    System.out.println("clazz.getName() = " + clazz.getName());
  }
}
