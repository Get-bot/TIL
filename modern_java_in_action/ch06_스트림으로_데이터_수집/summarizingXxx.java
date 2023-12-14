package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;

import static java.util.stream.Collectors.*;

public class summarizingXxx {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    IntSummaryStatistics menuStatistics = menu.stream()
        .collect(summarizingInt(Dish::getCalories));

    LongSummaryStatistics menuStatisticsLong = menu.stream()
        .collect(summarizingLong(Dish::getCalories));

    DoubleSummaryStatistics menuStatisticsDouble = menu.stream()
        .collect(summarizingDouble(Dish::getCalories));

    System.out.println(menuStatistics);
  }
}
