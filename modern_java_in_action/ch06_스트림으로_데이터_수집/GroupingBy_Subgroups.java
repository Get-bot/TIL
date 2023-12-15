package ch06_스트림으로_데이터_수집;

import classes.Dish;
import classes.DishType;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class GroupingBy_Subgroups {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    Map<DishType, Long> typesCount = menu.stream()
        .collect(groupingBy(Dish::getType, counting()));

    System.out.println("typesCount = " + typesCount);

    Map<DishType, Optional<Dish>> mostCaloricByType = menu.stream()
        .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

    System.out.println("mostCaloricByType = " + mostCaloricByType);

    Map<DishType, Dish> mostCaloricByType_CollectingAndThen = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                collectingAndThen(
                    maxBy(comparingInt(Dish::getCalories)),
                    Optional::get
                )
            )
        );

    System.out.println("mostCaloricByType_CollectingAndThen = " + mostCaloricByType_CollectingAndThen);
  }
}
