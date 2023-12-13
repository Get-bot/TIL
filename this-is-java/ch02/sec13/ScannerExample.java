package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열 입력> ");
        String inputString = scanner.nextLine();
        System.out.println(inputString);

        System.out.print("정수 입력> ");
        int inputInt = scanner.nextInt();
        System.out.println(inputInt);

        System.out.print("실수 입력> ");
        double inputDouble = scanner.nextDouble();
        System.out.println(inputDouble);

        scanner.close();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 스레드가 실행할 코드
            }
        }
        );
    }
}