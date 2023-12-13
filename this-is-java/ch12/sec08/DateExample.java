package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
  public static void main(String[] args) {
    Date currentDate = new Date();
    String strCurDate = currentDate.toString();
    System.out.println(currentDate);
    System.out.println(strCurDate);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
    System.out.println(sdf.format(currentDate));
  }
}
