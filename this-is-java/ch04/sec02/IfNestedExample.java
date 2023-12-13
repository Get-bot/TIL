package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int) (Math.random() * 20) + 81; // 81 ~ 100 사이의 정수 랜덤 생성

        String grade;

        if(score >= 90) {
            if(score >= 95) {
                grade = "A+";
            } else {
                grade = "A";
            }
        } else {
            if(score >= 85) {
                grade = "B+";
            } else {
                grade = "B";
            }
        }

        System.out.println(score + "점은 " + grade + "등급입니다.");
    }
}
