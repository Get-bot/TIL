package ch06.sec08.exam01;

public class Calculator {
    //리턴값이 없는 메소드 선언
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    //리턴값이 있는 메소드 선언
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 int를 리턴하는 메소드 선언
    int plus(int x, int y) {
        return x + y;
    }

    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 double을 리턴하는 메소드 선언
    double divide(int x, int y) {
        return (double)x / (double)y;
    }
}
