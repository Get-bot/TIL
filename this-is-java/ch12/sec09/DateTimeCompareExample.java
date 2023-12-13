package ch12.sec09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeCompareExample {
  public static void main(String[] args) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분");

    LocalDateTime startDate = LocalDateTime.parse("2019년 12월 25일 오전 10시 15분", dateTimeFormatter);
    System.out.println("startDate = " + startDate);

    LocalDateTime endDate = LocalDateTime.parse("2020년 12월 25일 오전 10시 15분", dateTimeFormatter);
    System.out.println("endDate = " + endDate);

    if (startDate.isBefore(endDate)) {
      System.out.println("진행 중입니다.");
    } else if (startDate.isEqual(endDate)) {
      System.out.println("종료합니다.");
    } else if (startDate.isAfter(endDate)) {
      System.out.println("종료했습니다.");
    }

    long remainSeconds = startDate.until(endDate, java.time.temporal.ChronoUnit.SECONDS);
    System.out.println("남은 초 = " + remainSeconds);

    long remainDays = startDate.until(endDate, java.time.temporal.ChronoUnit.DAYS);
    System.out.println("남은 일 = " + remainDays);

    long remainMonths = startDate.until(endDate, java.time.temporal.ChronoUnit.MONTHS);
    System.out.println("남은 월 = " + remainMonths);

    long remainYears = startDate.until(endDate, java.time.temporal.ChronoUnit.YEARS);
    System.out.println("남은 년 = " + remainYears);


  }
}
