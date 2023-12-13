package ch14.sec06.exam02;

public class WorkObject {
    public synchronized void methodA() {
        System.out.println("ThreadA의 methodA() 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void methodB() {
        System.out.println("ThreadB의 methodB() 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
