package ch15.sec02.exam02;

import ch15.sec02.exam01.Board;

import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        //Vector 컬렉션 생성
        List<Board> list = new Vector<>();

        Thread thread = new Thread(() -> {
            //Board 객체를 저장
            for(int i = 0; i < 1000000; i++) {
                list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
            }
        });

        Thread thread2 = new Thread(() -> {
            //Board 객체를 저장
            for(int i = 0; i < 1000000; i++) {
                list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
            }
        });

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체수: " + size);
        System.out.println();
    }
}
