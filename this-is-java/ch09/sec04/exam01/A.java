package ch09.sec04.exam01;

public class A {
    //생성자
    public A() {
        //로컬 클래스 선언
        class B {}

        //로컬 객체 생성
        B b = new B();
    }

    public void method() {
        //로컬 클래스 생성
        class B {}

        //로컬 객체 생성
        B b = new B();
    }

}
