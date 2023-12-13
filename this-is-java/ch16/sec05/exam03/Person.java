package ch16.sec05.exam03;

public class Person {
  public Member getMember1(Creatable1 creatable) {
    return creatable.create("winter");
  }

  public Member getMember2(Creatable2 creatable) {
    return creatable.create("winter", "한겨울");
  }
}
