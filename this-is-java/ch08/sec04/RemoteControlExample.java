package ch08.sec04;

public class RemoteControlExample {
    public static void main(String[] args) {
        //인터페이스 선언
        RemoteControl rc;

        //Television 객체를 인터페이스 타입에 대입
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        //Audio 객체를 인터페이스 타입에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        rc.notify();
    }
}
