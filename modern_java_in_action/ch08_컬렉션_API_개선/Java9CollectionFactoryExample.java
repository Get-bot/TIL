package ch08_컬렉션_API_개선;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9CollectionFactoryExample {
  public static void main(String[] args) {
    List<String> friends = new ArrayList<>();
    friends.add("Raphael");
    friends.add("Olivia");
    friends.add("Thibaut");

    // 고정 크기의 리스트를 생성하므로 요소를 추가하려고 하면 예외가 발생한다.
    List<String> friendsFactory = Arrays.asList("Raphael", "Olivia", "Thibaut");

    // Java 9에서는 List, Set, Map 인터페이스에 정적 팩토리 메서드를 제공한다.
    Set<String> friendsSet = new HashSet<>(friendsFactory);

    // stream api 이용
    Set<String> friendsSetStream = Stream.of("Raphael", "Olivia", "Thibaut").collect(Collectors.toSet());

    //java9 부터는 List.of(), Set.of(), Map.of() 정적 팩토리 메서드를 제공한다.
    //.of 로 만든 컬렉션은 불변이다.
    List<String> friendsOf = List.of("Raphael", "Olivia", "Thibaut");
    Set<String> friendsOfSet = Set.of("Raphael", "Olivia", "Thibaut");
    Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

    // Map.ofEntries() 정적 팩토리 메서드를 이용하면 10개 이상의 키-값 쌍을 가진 맵을 생성할 수 있다.
    Map<String, Integer> ageOfEntriesFriends = Map.ofEntries(
        Map.entry("Raphael", 30),
        Map.entry("Olivia", 25),
        Map.entry("Thibaut", 26)
    );
  }
}
