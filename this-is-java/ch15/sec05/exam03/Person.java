package ch15.sec05.exam03;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person implements Comparable<Person> {
  private String name;
  private int age;

  @Override
  public int compareTo(Person o) {
    return Integer.compare(age, o.age);
  }
}
