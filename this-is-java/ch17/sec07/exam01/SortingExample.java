package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            int randomScore = random.nextInt(100);
            students.add(new Student("신용권"+i, randomScore));
        }

        long start = System.nanoTime();

        students.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getScore() + ", " + s.getName()));

        System.out.println();

        long end = System.nanoTime();

        System.out.println("걸린시간: " + (end - start) + " ns");

        start = System.nanoTime();

        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore))
                .forEach(s -> System.out.println(s.getScore() + ", " + s.getName()));

        System.out.println();

        end = System.nanoTime();

        System.out.println("걸린시간: " + (end - start) + " ns");

        start = System.nanoTime();

        students.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getScore() + ", " + s.getName()));

        System.out.println();

        end = System.nanoTime();

        System.out.println("걸린시간: " + (end - start) + " ns");

    }
}
