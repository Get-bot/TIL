package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        //ArrayList 생성
        List<Board> list = new ArrayList<Board>();

        //객체 추가
        for(int i = 0; i < 10; i++) {
            list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
        }

        //저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체수: " + size);
        System.out.println();

        //특정 인덱스의 객체 얻기
        Board someBoard = list.get(2);
        System.out.println(someBoard.toString());

        System.out.println();

        //모든 객체를 하나씩 가져오기
        for(Board board : list) {
            System.out.println(board.toString());
        }

        System.out.println();

        //객체 삭제
        list.remove(2); //2번 인덱스 객체(3번째 객체) 삭제
        list.remove(3); //3번 인덱스 객체(4번째 객체) 삭제
    }


}
