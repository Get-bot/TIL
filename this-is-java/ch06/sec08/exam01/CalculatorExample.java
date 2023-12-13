package ch06.sec08.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        //Calculator 객체 생성
        Calculator myCalc = new Calculator();

        //Calculator 객체의 powerOn() 메소드 호출
        myCalc.powerOn();

        //Calculator 객체의 plus() 메소드 호출
        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);

        //Calculator 객체의 divide() 메소드 호출
        double result2 = myCalc.divide(5, 6);
        System.out.println("result2: " + result2);

        //Calculator 객체의 powerOff() 메소드 호출
        myCalc.powerOff();
    }
}
