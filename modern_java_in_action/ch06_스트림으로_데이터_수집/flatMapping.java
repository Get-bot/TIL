package ch06_스트림으로_데이터_수집;


import classes.Dish;
import classes.DishTag;
import classes.DishType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class flatMapping {
  public static void main(String[] args) {

    List<Dish> menu = Dish.getDefaultMenu();
    Map<String, List<String>> dishTags = DishTag.getMapedDefaultTags();

    Map<DishType, Set<String>> dishNamesByType = menu.stream()
        .collect(
            groupingBy(Dish::getType,
                flatMapping(
                    dish -> dishTags.get(dish.getName()).stream(),
                    toSet()
                )
            )
        );

    System.out.println("dishNamesByType = " + dishNamesByType);
  }
}
