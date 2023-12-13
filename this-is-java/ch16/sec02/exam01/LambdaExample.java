package ch16.sec02.exam01;

public class LambdaExample {
  public static void main(String[] args) {
    Person person = new Person();
    person.action(() -> System.out.println("복사를 합니다."));

    person.action(() -> {
      String str = "람다식을 합니다.";
      System.out.println(str);
    });

    person.action(() -> {
      for(int i=0; i<10; i++) {
        System.out.println(i);
      }
    });
  }
}
