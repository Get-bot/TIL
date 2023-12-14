package ch06_스트림으로_데이터_수집;

import classes.Dish;
import classes.DishType;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Filtering {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    //grouping 내부에서 필터링
    Map<DishType, List<Dish>> caloricDishesByType = menu.stream()
        .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));

    System.out.println("caloricDishesByType = " + caloricDishesByType);
  }
}
