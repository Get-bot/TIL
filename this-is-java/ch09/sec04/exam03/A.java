package ch09.sec04.exam03;

public class A {
    //메소드
    public void method1(int arg) {
        //로컬 변수
        int var = 1;

        //로컬 클래스
        class B {
            //메소드
            void method2(){
                //로컬 변수 읽기
                System.out.println("arg " + arg);
                System.out.println("var = " + var);

                //로컬 변수 수정
                //arg = 100; //final 특성 때문에 수정 불가
                //var = 200; //final 특성 때문에 수정 불가
        }}

        //로컬 객체 생성
        B b = new B();
        //로컬 객체 메소드 생성
        b.method2();

        //로컬 변수 수정
//        arg = 100; //final 특성 때문에 수정 불가
//        var = 200; //final 특성 때문에 수정 불가

    }
}
