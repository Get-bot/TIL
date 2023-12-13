package ch07.sec03.exam02;

public class Phone {
    //필드 선언
    public String model;
    public String color;

    //매개 변수를 갖는 생성자 생성
    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("Phone(String, String) 생성자 호출");
    }
}
