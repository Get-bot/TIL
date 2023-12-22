package ch08_컬렉션_API_개선;

import classes.Transaction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static java.util.Map.entry;

public class Java8CollectionAPIImprovements {

  static MessageDigest messageDigest;

  static {
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {

    List<Transaction> transactions = new ArrayList<>(Transaction.getDefaultTransactions());

    /*
     * List,Set removeIf
     */

    // ConcurrentModificationException 발생
    for (Transaction transaction : transactions) {
      if (Character.isDigit(transaction.getTrader().getName().charAt(0))) {
        transactions.remove(transaction);
      }
    }

    //내부적으로 for-each 루프는 Iterator 객체를 사용한다.
//    for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext(); ) {
//      Transaction transaction = iterator.next();
//      if(Character.isDigit(transaction.getTrader().getName().charAt(0))){
//        transaction.remove();
//      }
//    }

    //Iterator 객체를 명시적으로 사용하고 그 객체의 remove 메서드를 호출한다.
    for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext(); ) {
      Transaction transaction = iterator.next();
      if (Character.isDigit(transaction.getTrader().getName().charAt(0))) {
        iterator.remove();
      }
    }

    //removeIf 메서드를 이용한다.
    transactions.removeIf(transaction -> Character.isDigit(transaction.getTrader().getName().charAt(0)));


    /*
     * List,Set replaceAll
     */

    List<String> referenceCodes = new ArrayList<>(List.of("a12", "C14", "b13"));

    //새 문자열 생성
    referenceCodes.stream()
        .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
        .forEach(System.out::println);

    //iterator를 이용한 문자열 생성
    for (ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext(); ) {
      String code = iterator.next();
      iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
    }

    //replaceAll 메서드를 이용한다.
    referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));

    /*
     * Map forEach
     */
    Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

    //Map.Entry<K, V>를 이용한 반복
    for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
      String friend = entry.getKey();
      Integer age = entry.getValue();
      System.out.println(friend + " is " + age + " years old");
    }

    //forEach 메서드를 이용한 반복
    ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old"));

    /*
     * Map comparingByKey, comparingByValue
     */

    Map<String, String> favouriteMovies = Map.ofEntries(
        entry("Raphael", "Star Wars"),
        entry("Cristina", "Matrix"),
        entry("Olivia", "James Bond")
    );

    //Map의 키를 기준으로 정렬
    favouriteMovies.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(System.out::println);

    //Map의 값으로 정렬
    favouriteMovies.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .forEachOrdered(System.out::println);

    /*
     * Map GetOrDefault
     */

    Map<String, String> favoriteMovies_GetOrDefault = Map.ofEntries(
        entry("Raphael", "Star Wars"),
        entry("Olivia", "James Bond")
    );

    //getOrDefault 메서드를 이용한 값 가져오기
    System.out.println(favoriteMovies_GetOrDefault.getOrDefault("Olivia", "Matrix"));
    System.out.println(favoriteMovies_GetOrDefault.getOrDefault("Thibaut", "Matrix"));


    /*
     * computeIfAbsent
     */

    Map<String, byte[]> dataToHash = new HashMap<>();

    File file = new File("modern_java_in_action/ch08_컬렉션_API_개선/test.txt");
    try {
      List<String> lines = Files.readAllLines(file.toPath());

      lines.forEach(
          line -> dataToHash.computeIfAbsent(
              line, // 맵에서 찾을 키
              Java8CollectionAPIImprovements::calculateDigest // 키가 없을 경우 계산할 해시
          )
      );

      dataToHash.forEach((key, value) -> System.out.println(key + " " + Arrays.toString(value)));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Map<String, List<String>> favouriteMovies2 = new HashMap<>();
    favouriteMovies2.put("Raphael", null);
    favouriteMovies2.put("Olivia", Arrays.asList("James Bond"));

    String friend = "Raphael";
    List<String> movies = favouriteMovies2.get(friend);
    if (movies == null) {
      movies = new ArrayList<>();
      favouriteMovies2.put(friend, movies);
    }
    movies.add("Star Wars");

    //computeIfAbsent 메서드를 이용한 값 추가
    favouriteMovies2.computeIfAbsent("Raphael", name -> new ArrayList<>()).add("Star Wars");

    /*
     * Map remove
     */

    String key = "Raphael";
    String value = "Star Wars";
    if (favouriteMovies2.containsKey(key) && Objects.equals(favouriteMovies2.get(key), value)) {
      favouriteMovies2.remove(key);
    }

    //remove 메서드를 이용한 값 삭제
    favouriteMovies2.remove(key, value);

    /*
     * Map replaceAll, replace
     */

    Map<String, String> favouriteMovies3 = new HashMap<>();
    favouriteMovies3.put("Raphael", "Star Wars");
    favouriteMovies3.put("Olivia", "james Bond");

    favouriteMovies3.replaceAll((friend_replace, movie) -> movie.toUpperCase());
    System.out.println(favouriteMovies3);

    favouriteMovies3.replace("Olivia", "james Bond", "Matrix");

    /*
     * Map merge
     */

    Map<String, Long> moviesToCount = new HashMap<>();
    moviesToCount.put("JamesBond", 1L);

    String movieName = "JamesBond";
    long count = moviesToCount.getOrDefault(movieName, 0L);
    if (count == 0) {
      moviesToCount.put(movieName, 1L);
    } else {
      moviesToCount.put(movieName, count + 1);
    }

    //merge 메서드를 이용한 값 추가
    moviesToCount.merge(movieName, 1L, (key_merge, count_merge) -> count_merge + 1);
  }

  private static byte[] calculateDigest(String key) { // SHA-256 해시를 계산하는 메서드
    return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
  }

}
