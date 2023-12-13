package ch14.sec05.exam02;

public class JoinExample {
    public static void main(String[] args) {
        sumTwoThread();
        sumOneThread();
    }

    private static void sumOneThread() {
        long start = System.nanoTime();
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum += i;
        }
        long end = System.nanoTime();

        System.out.println("1~100 합: " + sum);
        System.out.println("1~100 합 계산 시간: " + (end - start) + "ms");
    }

    private static void sumTwoThread() {
        long start = System.nanoTime();
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long end = System.nanoTime();

        System.out.println("멀티 스레드 1~100 합: " + sumThread.getSum());
        System.out.println("멀티 스레드 1~100 합 계산 시간: " + (end - start) + "ms");

    }
}


