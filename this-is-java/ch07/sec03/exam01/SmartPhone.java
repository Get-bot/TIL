package ch07.sec03.exam01;

public class SmartPhone extends Phone {
    //자식 생성자 선언
    public SmartPhone(String model, String color) {
        super(); //부모 생성자 호출
        this.model = model;
        this.color = color;
        System.out.println("SmartPhone(String, String) 생성자 호출");
    }
}
