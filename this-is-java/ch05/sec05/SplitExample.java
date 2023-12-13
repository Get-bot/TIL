package ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1,자바,학슴,참조, 타입 String을 학습한다.";

    //문자열 분리
        String[] tokens = board.split(",");

    //인덱스별로 일기
        System.out.println("번호" + tokens[0]);
        System.out.println("제목" + tokens[1]);
        System.out.println("내용" + tokens[2]);
        System.out.println("글쓴이" + tokens[3]);

    //for 문을 이용한 읽기
        for(String token : tokens) {
            System.out.println(token);
        }
    }
}
