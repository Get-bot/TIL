package ch07.sec08.exam02;

public class DriverExample {
    public static void main(String[] args) {
        //Driver 객체 생성
        Driver driver = new Driver();

        //매개값으로 Bus 객체를 주었을 때
        driver.drive(new Bus());

        //매개값으로 Taxi 객체를 주었을 때
        driver.drive(new Taxi());
    }
}
