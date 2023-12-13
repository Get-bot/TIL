package ch12.sec03.exam03;

public class ToStringExample {
  public static void main(String[] args) {
    SmartPhone myPhone = new SmartPhone("구글", "안드로이드");
    String strObj = myPhone.toString();
    System.out.println(strObj);
    System.out.println(myPhone);
  }
}
