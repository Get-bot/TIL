package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Transaction {
  private Trader trader;
  private int year;
  private int value;
  private Currency currency;

  public static List<Transaction> getDefaultTransactions() {
    List<Trader> traders = Trader.getDefaultTraders();
    List<Currency> currencies = Currency.getDefaultCurrencies();

    return List.of(
        new Transaction(traders.get(0), 2011, 300, currencies.get(0)),
        new Transaction(traders.get(1), 2012, 500, currencies.get(1)),
        new Transaction(traders.get(2), 2013, 700, currencies.get(2)),
        new Transaction(traders.get(0), 2014, 400, currencies.get(3)),
        new Transaction(traders.get(1), 2015, 350, currencies.get(4)),
        new Transaction(traders.get(3), 2016, 450, currencies.get(5)),
        new Transaction(traders.get(2), 2017, 520, currencies.get(6)),
        new Transaction(traders.get(1), 2018, 610, currencies.get(7)),
        new Transaction(traders.get(0), 2019, 280, currencies.get(8)),
        new Transaction(traders.get(3), 2020, 330, currencies.get(9)),
        // Repeat with different combinations
        new Transaction(traders.get(2), 2011, 450, currencies.get(1)),
        new Transaction(traders.get(3), 2012, 600, currencies.get(2)),
        new Transaction(traders.get(0), 2013, 350, currencies.get(3)),
        new Transaction(traders.get(1), 2014, 420, currencies.get(4)),
        new Transaction(traders.get(2), 2015, 510, currencies.get(5)),
        new Transaction(traders.get(3), 2016, 650, currencies.get(6)),
        new Transaction(traders.get(0), 2017, 300, currencies.get(7)),
        new Transaction(traders.get(1), 2018, 470, currencies.get(8)),
        new Transaction(traders.get(2), 2019, 530, currencies.get(9)),
        new Transaction(traders.get(3), 2020, 400, currencies.get(0)),
        // Continue with more combinations
        new Transaction(traders.get(0), 2011, 320, currencies.get(1)),
        new Transaction(traders.get(1), 2012, 450, currencies.get(2)),
        new Transaction(traders.get(2), 2013, 500, currencies.get(3)),
        new Transaction(traders.get(3), 2014, 370, currencies.get(4)),
        new Transaction(traders.get(0), 2015, 480, currencies.get(5)),
        new Transaction(traders.get(1), 2016, 560, currencies.get(6)),
        new Transaction(traders.get(2), 2017, 340, currencies.get(7)),
        new Transaction(traders.get(3), 2018, 430, currencies.get(8)),
        new Transaction(traders.get(0), 2019, 520, currencies.get(9)),
        new Transaction(traders.get(1), 2020, 390, currencies.get(0))
    );
  }
}
