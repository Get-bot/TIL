package ch06.sec11.exam01;

import java.lang.reflect.Field;

public class KoreanExample {
    public static void main(String[] args) {
        //객체 생성시 주민등록 번호와 이름을 저장하도록 생성자 호출
        Korean k1 = new Korean("123456-1234567", "계백");
        System.out.println("k1.nation: " + k1.nation);
        System.out.println("k1.ssn: " + k1.ssn);
        System.out.println("k1.name: " + k1.name);

        //Final 필드는 값 수정 불가
        //k1.nation = "usa";
        //k1.ssn = "654321-7654321";

        //비 final 필드는 값 수정 가능
        k1.name = "을지문덕";

    }
}
