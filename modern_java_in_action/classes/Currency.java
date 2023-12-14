package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Currency {
  private String code;

  public static List<Currency> getDefaultCurrencies() {
    return List.of(
        new Currency("USD"),
        new Currency("EUR"),
        new Currency("JPY"),
        new Currency("GBP"),
        new Currency("CHF"),
        new Currency("CAD"),
        new Currency("AUD"),
        new Currency("CNY"),
        new Currency("HKD"),
        new Currency("NZD")
    );
  }
}
