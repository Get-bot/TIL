package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class DishTag {
  private String name;
  private List<String> tags;

  public static Map<String, List<String>> getMapedDefaultTags() {
    return Map.of(
        "pork", List.of("greasy", "salty"),
        "beef", List.of("salty", "roasted"),
        "chicken", List.of("fried", "crisp"),
        "french fries", List.of("greasy", "fried"),
        "rice", List.of("light", "natural"),
        "season fruit", List.of("fresh", "natural"),
        "pizza", List.of("tasty", "salty"),
        "prawns", List.of("tasty", "roasted"),
        "salmon", List.of("delicious", "fresh")
    );
  }
}
