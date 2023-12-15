package ch06_스트림으로_데이터_수집;

import classes.CaloricLevel;
import classes.Dish;
import classes.DishType;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupingBy_MultiLevel {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    Map<DishType, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
        .collect(
            groupingBy(Dish::getType,
                groupingBy(CaloricLevel::getCaloricLevel)
            )
        );

    dishesByTypeCaloricLevel.forEach((key, value) -> {
      System.out.println("key = " + key);
      System.out.println("value = " + value);
    });
  }

}
