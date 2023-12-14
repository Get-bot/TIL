package ch06_스트림으로_데이터_수집;

import classes.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Maxby_Minby {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    // Comparator는 두 객체를 비교하는 데 사용
    Comparator<Dish> dishCaloriesComparator =
        Comparator.comparingInt(Dish::getCalories);

    //최댓값
    Optional<Dish> mostCalorieDish = menu.stream()
        .collect(maxBy(dishCaloriesComparator));

    //최솟값
    Optional<Dish> leastCalorieDish = menu.stream()
        .collect(minBy(dishCaloriesComparator));

  }
}
