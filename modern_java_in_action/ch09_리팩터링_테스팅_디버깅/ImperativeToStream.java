package ch09_리팩터링_테스팅_디버깅;

import classes.Dish;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ImperativeToStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getDefaultMenu();

        // 명령형
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }

        // 스트림
        List<String> dishNamesStream = menu.parallelStream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(toList());
    }
}
