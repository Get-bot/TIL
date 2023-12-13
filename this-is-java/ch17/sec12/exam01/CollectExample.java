package ch17.sec12.exam01;

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

    // 남학생들만 묶어서 List 생성
    List<Student> maleList = studentList.stream()
        .filter(s -> s.getSex().equals("남"))
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    List<Student> femaleList = studentList.stream()
        .filter(s -> s.getSex().equals("여"))
        .toList();

    maleList
        .forEach(s -> System.out.println(s.getName()));

    femaleList
        .forEach(s -> System.out.println(s.getName()));

    //학생의 이름을 키, 학생의 점수를 값으로 가지는 Map 생성
    Map<String, Integer> map = studentList.stream()
        .collect(Collectors.toMap(
            Student::getName,
            Student::getScore
        ));

    map.forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
