package ch15.sec02.exam03;

import ch15.sec02.exam01.Board;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Board> linkedList = new LinkedList<Board>();

        List<Board> arrayList = new ArrayList<Board>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(0, new Board("제목" + i, "내용" + i, "글쓴이" + i));
        }
        endTime = System.nanoTime();

        System.out.println("LinkedList 걸린시간: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(0, new Board("제목" + i, "내용" + i, "글쓴이" + i));
        }
        endTime = System.nanoTime();

        System.out.println("ArrayList 걸린시간: " + (endTime - startTime) + " ns");

    }
}
