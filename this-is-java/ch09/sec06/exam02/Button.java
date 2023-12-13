package ch09.sec06.exam02;

public class Button {
    //정적 중첩 인터페이스
    public static interface ClickListener {
        //추상메소드
        void onClick();
    }

    //필드
    Button.ClickListener listener; //인터페이스 타입 필드

    //메소드
    public void setOnClickListener(ClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        this.listener.onClick();
    }
}

