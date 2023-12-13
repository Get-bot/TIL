package ch17.sec11;

import java.util.ArrayList;
import java.util.List;
public class ReductionExample {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();

    studentList.add(new Student("홍길동", 92));
    studentList.add(new Student("신용권", 95));
    studentList.add(new Student("감자바", 88));

    int sum1 = studentList.stream()
        .mapToInt(Student::getScore)
        .sum();

    int sum2 = studentList.stream()
        .map(Student::getScore)
        .reduce(0, Integer::sum);

    System.out.println("sum1: " + sum1);
    System.out.println("sum2: " + sum2);
  }
}
