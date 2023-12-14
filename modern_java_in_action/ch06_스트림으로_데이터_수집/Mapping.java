package ch06_스트림으로_데이터_수집;

import classes.Dish;
import classes.DishType;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Mapping {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    Map<DishType, List<String>> dishNamesByType = menu.stream()
        .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

    System.out.println("dishNamesByType = " + dishNamesByType);
  }
}
