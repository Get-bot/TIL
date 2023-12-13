package ch15.sec08;

import java.util.*;

public class ImuutableExample {
  public static void main(String[] args) {
    //List 불변 컬렉션 생성
    List<String> immutableList = List.of("홍길동", "신용권", "김자바");
    immutableList.add("김자바"); //예외 발생

    //Set 불변 컬렉션 생성
    Set<String> immutableSet = Set.of("홍길동", "신용권", "김자바");
    immutableSet.add("김자바"); //예외 발생

    //Map 불변 컬렉션 생성
    Map<String, Integer> immutableMap = Map.ofEntries(
      Map.entry("홍길동", 1),
      Map.entry("신용권", 2),
      Map.entry("김자바", 3)
    );

    immutableMap.put("김자바", 4); //예외 발생

    //List 컬렉션을 불변 컬렉션으로 복사
    List<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("신용권");
    list.add("김자바");

    List<String> immutableList2 = List.copyOf(list);

    //Set 컬렉션을 불변 컬렉션으로 복사
    Set<String> set = new HashSet<>();
    set.add("홍길동");
    set.add("신용권");
    set.add("김자바");

    Set<String> immutableSet2 = Set.copyOf(set);

    //Map 컬렉션을 불변 컬렉션으로 복사
    Map<String, Integer> map = new HashMap<>();
    map.put("홍길동", 1);
    map.put("신용권", 2);
    map.put("김자바", 3);

    Map<String, Integer> immutableMap2 = Map.copyOf(map);

    //배열 불변 컬렉션으로 복사
    String[] array = {"홍길동", "신용권", "김자바"};
    List<String> immutableList3 = Arrays.asList(array);
  }
}
