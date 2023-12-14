package ch06_스트림으로_데이터_수집;

import classes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupingBy {
  public static void main(String[] args) {
    List<Transaction> transactions = Transaction.getDefaultTransactions();

    // 명령형 버전
    Map<Currency, List<Transaction>> transactionsByCurrenciesOld = new HashMap<>();

    for (Transaction transaction : transactions) {
      Currency currency = transaction.getCurrency();
      List<Transaction> transactionsForCurrency = transactionsByCurrenciesOld.get(currency);
      if (transactionsForCurrency == null) {
        transactionsForCurrency = new ArrayList<>();
        transactionsByCurrenciesOld.put(currency, transactionsForCurrency);
      }
      transactionsForCurrency.add(transaction);
    }

    System.out.println("transactionsByCurrenciesOld = " + transactionsByCurrenciesOld);

    //함수형 버전
    Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
        .collect(groupingBy(Transaction::getCurrency));

    System.out.println("transactionsByCurrencies = " + transactionsByCurrencies);

    List<Dish> menu = Dish.getDefaultMenu();

    Map<DishType, List<Dish>> dishesByType = menu.stream()
        .collect(groupingBy(Dish::getType));

    System.out.println("dishesByType = " + dishesByType);

    // 다수준 그룹화
    Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
        .collect(groupingBy(dish -> {
          if (dish.getCalories() <= 400) return CaloricLevel.DIET;
          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
          else return CaloricLevel.FAT;
        }));

    System.out.println("dishesByCaloricLevel = " + dishesByCaloricLevel);

    Map<DishType, List<Dish>> highCaloricDishesByType = menu.stream()
        .filter(dish -> dish.getCalories() < 500)
        .collect(groupingBy(Dish::getType));

    //두번째 Collector 안으로 필터 프레디케이트 이동
    Map<DishType, List<Dish>> caloricDishesByType = menu.stream()
        .collect(groupingBy(Dish::getType,
            filtering(dish -> dish.getCalories() > 500, toList())));

  }
}
