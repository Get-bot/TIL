package ch14.sec07.exam02;

public class PrintThread extends Thread{
    public void run() {
        // 실행 시간 파악

        try {
            while(true) {
                System.out.println("실행 중");
                System.out.println(System.nanoTime());
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
