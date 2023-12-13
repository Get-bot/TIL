package ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        //Car 객체 생성
        Car car = new Car();

        car.setGas(5);

        //Car 객체의 run 메소드 호출
        car.run();

        //Car 객체의 gas 필드값 읽기
        System.out.println("gas 잔량: " + car.gas);
    }
}
