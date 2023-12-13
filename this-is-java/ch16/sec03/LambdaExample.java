package ch16.sec03;

public class LambdaExample {
  public static void main(String[] args) {
    Person person = new Person();
    person.action1((name, job) -> {
      System.out.println(name + "은 " + job + "입니다.");
    });

    person.action2(System.out::println);
  }
}
