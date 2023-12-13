package ch16.sec02.exam02;

public class ButtonExample {
  public static void main(String[] args) {
    Button btn = new Button();

    btn.setOnClickListener(new Button.ClickListener() {
      @Override
      public void onClick() {
        System.out.println("전화를 겁니다.");
      }
    });
    btn.touch();

    btn.setOnClickListener(() -> {
      System.out.println("전화를 겁니다.");
    });

    btn.touch();
  }
}
