package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.List;

import static java.util.stream.Collectors.*;

public class SummingXxx {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    //summingInt의 인수로 전달된 함수는 객체를 int로 매핑한 컬렉터를 반환
    int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

    long totalCaloriesLong = menu.stream().collect(summingLong(Dish::getCalories));

    Double totalCaloriesDouble = menu.stream().collect(summingDouble(Dish::getCalories));

    System.out.println(totalCalories);
    System.out.println(totalCaloriesLong);
    System.out.println(totalCaloriesDouble);
  }
}
