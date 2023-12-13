package ch16.sec02.exam02;

public class Button {
  @FunctionalInterface
  public static interface ClickListener {
    void onClick();
  }

  private ClickListener listener;

  public void setOnClickListener(ClickListener listener) {
    this.listener = listener;
  }

  public void touch() {
    listener.onClick();
  }
}
