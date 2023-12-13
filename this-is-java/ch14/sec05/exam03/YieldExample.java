package ch14.sec05.exam03;

public class YieldExample {
    public static void main(String[] args) {
        WorkThread thread1 = new WorkThread("철수");
        WorkThread thread2 = new WorkThread("영희");
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        thread1.work = false;


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        thread1.work = true;
    }
}
