package ch06_스트림으로_데이터_수집;

import classes.CaloricLevel;
import classes.Dish;
import classes.DishType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Grouping_and_anothor_collectors {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    Map<DishType, Integer> totalCaloriesByType = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                summingInt(Dish::getCalories)
            )
        );

    System.out.println("totalCaloriesByType = " + totalCaloriesByType);

    //각 요리 형식에 존재하는 CaloricLevel을 찾는다.
    //mapping
    Map<DishType, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                mapping(
                    CaloricLevel::getCaloricLevel,
                    toSet()
                )
            )
        );

    //toCollection
    Map<DishType, Set<CaloricLevel>> caloricLevelsByType_toCollection = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                mapping(
                    CaloricLevel::getCaloricLevel,
                    toCollection(HashSet::new)
                )
            )
        );

    System.out.println("caloricLevelsByType = " + caloricLevelsByType);
    System.out.println("caloricLevelsByType_toCollection = " + caloricLevelsByType_toCollection);
  }
}
