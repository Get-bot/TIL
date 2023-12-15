package ch06_스트림으로_데이터_수집;

import classes.Dish;
import classes.DishType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class PartitioningBy {
  public static void main(String[] args) {
    List<Dish> menu = Dish.getDefaultMenu();

    //모든 요리를 채식 요리와 아닌 요리로 구분
    Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
        .collect(partitioningBy(Dish::isVegetarian));

    //참값의 키로 맵에서 모든 채식 요리를 가져옴
    List<Dish> vegetarianDishes = partitionedMenu.get(true);

    //메뉴 리스트로 생성한 스트림을 프레디케이트로 필터링한 다음에 별도의 리스트에 결과 수집
    List<Dish> vegetarianDishes_filter = menu.stream()
        .filter(Dish::isVegetarian)
        .collect(toList());

    System.out.println("partitionedMenu = " + partitionedMenu);
    System.out.println("vegetarianDishes = " + vegetarianDishes);
    System.out.println("vegetarianDishes_filter = " + vegetarianDishes_filter);

    //오버로드된 partitioningBy
    Map<Boolean, Map<DishType, List<Dish>>> vegetarianDishesByType = menu.stream()
        .collect(
            partitioningBy(Dish::isVegetarian, // 분할 함수
                groupingBy(Dish::getType) // 두 번째 컬렉터
            )
        );

    System.out.println("vegetarianDishesByType = " + vegetarianDishesByType);

    //채식 요리와 채식이 아닌 요리의 가각 그룹에서 가장 칼로리가 높은 요리
    Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
        .collect(
            partitioningBy(Dish::isVegetarian,
                    collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories)),
                        Optional -> Optional.get()
                    )
                )
        );

    System.out.println("mostCaloricPartitionedByVegetarian = " + mostCaloricPartitionedByVegetarian);

    //채식주의자, 칼로리 조건
    Map<Boolean, Map< Boolean, List<Dish>>> vegetarianCalories =  menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(d -> d.getCalories()>500)));

    //프레디케이트가 아니므로 반환x
//  menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(Dish::getType)));

    //채식주의자 카운팅
    Map<Boolean, Long> vegetarianCount = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));

    System.out.println("vegetarianCalories = " + vegetarianCalories);
    System.out.println("vegetarianCount = " + vegetarianCount);

    //정수 n을 받아서 2에서 n까지 자연수를 소수와 비소수로 구분


  }
  public boolean isPrime(int candidate) {
    int candidateRoot = (int) Math.sqrt((double) candidate);
    return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
  }

  public Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2, n).boxed().collect(
        partitioningBy(candidate -> isPrime(candidate))
    );
  }

}
