package ch07.sec08.exam01;

public class HankookTire extends Tire {
    //메소드 재정의
    @Override
    public void run() {
        System.out.println("한국 타이어가 회전합니다.");
    }
}
