package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Trader {
  private String name;
  private String city;

  public static List<Trader> getDefaultTraders () {
    return List.of(
        new Trader("Raoul", "Cambridge"),
        new Trader("Mario", "Milan"),
        new Trader("Alan", "Cambridge"),
        new Trader("Brian", "Cambridge")
    );
  }
}
