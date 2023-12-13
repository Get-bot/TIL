package ch17.sec07.exam02;

import java.util.List;
import java.util.ArrayList;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("홍길동", 92));
        students.add(new Student("신용권", 95));
        students.add(new Student("감자바", 88));

        students.stream()
                .sorted((x, y) -> Integer.compare(x.getScore(), y.getScore()))
                .forEach(s -> System.out.println(s.getScore() + ", " + s.getName()));

        System.out.println();

        students.stream()
                .sorted((x, y) -> Integer.compare(y.getScore(), x.getScore()))
                .forEach(s -> System.out.println(s.getScore() + ", " + s.getName()));

        System.out.println();


    }
}
