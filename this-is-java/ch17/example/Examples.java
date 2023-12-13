package ch17.example;

import java.util.ArrayList;
import java.util.List;

public class Examples {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("This is java");
    list.add("That is C");
    list.add("What is java2");

    list.stream()
        .filter(s -> s.contains("java"))
        .forEach(System.out::println);

  }
}
