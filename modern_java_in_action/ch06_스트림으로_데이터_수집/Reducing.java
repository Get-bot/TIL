package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Reducing {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    int totalCaloriesReducing = menu.stream()
        .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

    //한 개의 인수 이용
    Optional<Dish> mostCaloriesDish = menu.stream()
        .collect(
            reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
        );

    //단순화
    int totalCalories = menu.stream()
        .collect(reducing(0, Dish::getCalories, Integer::sum));

    System.out.println(totalCaloriesReducing);
    System.out.println(mostCaloriesDish);
    System.out.println(totalCalories);
  }
}
