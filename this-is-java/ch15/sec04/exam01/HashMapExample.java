package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
  public static void main(String[] args) {
    //Map 컬렌션 생성
    Map<String, Integer> map = new HashMap<>();

    //객체 저장
    map.put("홍길동", 85);
    map.put("일지매", 90);
    map.put("임꺽정", 80);
    map.put("홍길동", 95); // 키가 동일하므로 제일 마지막에 저장한 값이 저장됨

    System.out.println("총 Entry 수: " + map.size());
    System.out.println();

    //키로 값 얻기
    System.out.println("\t홍길동: " + map.get("홍길동"));
    System.out.println();

    //키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
    Set<String> keySet = map.keySet();
    for (String key : keySet) {
      Integer value = map.get(key);
      System.out.println("\t" + key + ": " + value);
    }

    //엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
    Set<Entry<String, Integer>> entrySet = map.entrySet();
    Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();

    for (Entry<String, Integer> entry : entrySet) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("\t" + key + ": " + value);
    }

    //객체 삭제
    map.remove("홍길동");
    System.out.println("총 Entry 수: " + map.size());
  }
}
