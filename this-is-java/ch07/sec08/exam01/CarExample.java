package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        //Car 객체 생성
        Car car = new Car();

        //Tire 객체 장착
        car.tire = new Tire();
        car.run();

        //HankookTire 객체 장착
        car.tire = new HankookTire();
        car.run();

        //KumhoTire 객체 장착
        car.tire = new KumhoTire();
        car.run();
    }
}
