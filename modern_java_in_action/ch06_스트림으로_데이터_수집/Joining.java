package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Joining {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    String shortMenu = menu.stream()
        .map(Dish::getName)
        .collect(joining());

    String shortMenuSeparator = menu.stream()
        .map(Dish::getName)
        .collect(joining(", "));

    System.out.println(shortMenu);
    System.out.println(shortMenuSeparator);
  }
}
