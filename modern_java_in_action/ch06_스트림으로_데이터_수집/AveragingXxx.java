package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.List;

import static java.util.stream.Collectors.*;

public class AveragingXxx {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

    double avgCaloriesLong = menu.stream().collect(averagingLong(Dish::getCalories));

    double avgCaloriesDouble = menu.stream().collect(averagingDouble(Dish::getCalories));
  }
}
