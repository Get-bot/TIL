package ch06;

import ch06.classes.Currency;
import ch06.classes.Trader;
import ch06.classes.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingBy {
  public static void main(String[] args) {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");

    Currency krw = new Currency("KRW");
    Currency usd = new Currency("USD");
    Currency jpy = new Currency("JPY");
    Currency eur = new Currency("EUR");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(raoul, 2011, 300, krw),
        new Transaction(mario, 2012, 1000, usd),
        new Transaction(mario, 2012, 400, krw),
        new Transaction(alan, 2012, 710, jpy),
        new Transaction(alan, 2012, 700, eur),
        new Transaction(alan, 2012, 950, krw),
        new Transaction(alan, 2012, 950, krw)
    );


    //통화별로 트랜잭션을 그룹화

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

    System.out.println(transactionsByCurrenciesOld);

    //함수형 버전
    Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
        .collect(Collectors.groupingBy(Transaction::getCurrency));

    System.out.println(transactionsByCurrencies);
  }
}
