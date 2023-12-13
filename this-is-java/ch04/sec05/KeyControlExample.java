package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int spped = 0;

        while (run) {
            System.out.println("---------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("---------------------------");
            System.out.print("선택: ");

            int keyCode = scanner.nextInt();

            if (keyCode == 1) {
                spped++;
                System.out.println("현재 속도=" + spped);
            } else if (keyCode == 2) {
                spped--;
                System.out.println("현재 속도=" + spped);
            } else if (keyCode == 3) {
                run = false;
            }
        }

        System.out.println("프로그램 종료");
    }
}
