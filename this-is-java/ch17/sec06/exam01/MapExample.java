package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MapExample {
    public static void main(String[] args) {
        //List 컬렉션 생성
        List<Student> list = new ArrayList<Student>();

        list.add(new Student("홍길동", 85));
        list.add(new Student("홍길동", 92));
        list.add(new Student("홍길동", 87));

        //총점 구하기
        OptionalDouble average = list.stream().mapToInt(Student::getScore).average();
        if(average.isPresent()) {
            System.out.println("평균 점수: " + average.getAsDouble());
        } else {
            System.out.println("평균 점수: 0.0");
        }


        //Student를 score 스트림으로 변환
        list.stream().mapToInt(Student::getScore).forEach(System.out::println);
    }
}
