package ch09.sec06.exam03;

import ch09.sec06.exam02.Button;

public class ButtonExample {
    public static void main(String[] args) {
        //OK 버튼 객체 생성
        Button btnOk = new Button();

        //Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("OK 버튼이 클릭됨");
            }
        }

        //Ok 버튼 객체에 ClickListener 구현 객체 주입
        btnOk.setOnClickListener(new OkListener());

        //Ok 버튼 클릭
        btnOk.click();

        //-------------------------------------------------------

        //Cancel 버튼 객체 생성
        Button btnCancel = new Button();

        //Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
        class CancelListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Cancel 버튼이 클릭됨");
            }
        }

        //Cancel 버튼 객체에 ClickListener 구현 객체 주입
        btnCancel.setOnClickListener(new CancelListener());

        //Cancel 버튼 클릭
        btnCancel.click();

    }
}
