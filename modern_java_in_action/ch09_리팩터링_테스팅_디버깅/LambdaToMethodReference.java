package ch09_리팩터링_테스팅_디버깅;

import classes.CaloricLevel;
import classes.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class LambdaToMethodReference {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getDefaultMenu();

        //람다 표현식
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
            .collect(groupingBy(
                dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }
            ));

        //메서드 참조
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu.stream()
            .collect(groupingBy(CaloricLevel::getCaloricLevel));



        //저수준 리듀스
        int totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (c1, c2) -> c1 + c2);

        //메서드 참조
        int totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
    }
}
