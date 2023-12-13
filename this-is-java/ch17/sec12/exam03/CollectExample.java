package ch17.sec12.exam03;

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

    Map<String, Double> map = studentList.stream()
        .collect(Collectors.groupingBy(
            Student::getSex,
            Collectors.averagingDouble(Student::getScore)
        ));

    System.out.println("남학생 평균 점수: " + map.get("남"));
    System.out.println("여학생 평균 점수: " + map.get("여"));
    System.out.println(map);
  }
}
