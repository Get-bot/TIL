package ch12.sec09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분");
    String nowString = now.format(dateTimeFormatter);
    System.out.println(nowString);

    LocalDateTime result1 = now.plusYears(1);
    System.out.println(result1);
    LocalDateTime result2 = now.minusMonths(2);
    System.out.println(result2);
    LocalDateTime result3 = now.plusDays(2);
    System.out.println(result3);
  }
}
