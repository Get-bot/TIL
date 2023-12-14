package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Counting {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    long howManyDishes = menu.stream().collect(Collectors.counting());
    System.out.println("The menu consists of " + howManyDishes + " dishes.");

    //Skip unnecessary steps
    long skipSteps_howManyDishes = menu.stream().count();
    System.out.println("The menu consists of " + skipSteps_howManyDishes + " dishes.");
  }
}