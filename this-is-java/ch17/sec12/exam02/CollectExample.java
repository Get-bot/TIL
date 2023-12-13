package ch17.sec12.exam02;

import ch17.sec12.exam01.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();

    studentList.add(new Student("홍길동", "남", 20));
    studentList.add(new Student("김수애", "여", 25));
    studentList.add(new Student("신용권", "남", 30));
    studentList.add(new Student("박수미", "여", 35));

    Map<String, List<Student>> map = studentList.stream()
        .collect(Collectors.groupingBy(Student::getSex));

    List<Student> maleList = map.get("남");
    maleList
        .forEach(s -> System.out.println(s.getName()));

    List<Student> femaleList = map.get("여");
    femaleList
        .forEach(s -> System.out.println(s.getName()));

  }
}
