package ch09.sec07.exam02;

public class HomeControlExample {
    public static void main(String[] args) {
        //Home 객체 생성
        Home home = new Home();

        //익명 구현 객체가 대입된 필드 사용
        home.method1();

        //익명 구현 객체가 대입된 로컬 변수 사용
        home.method2();

        //익명 구현 객체를 매개값으로 사용
        home.method3(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("스마트티비를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("스마트티비를 끕니다.");
            }
        });
    }
}
