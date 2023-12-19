package ch07_병렬_데이터_처리와_성능;

import java.util.Spliterator;

public class WordCounterSpliterator implements Spliterator<Character> {
  private final String string;
  private int currentChar = 0;

  public WordCounterSpliterator(String string) {
    this.string = string;
  }

  @Override
  public boolean tryAdvance(java.util.function.Consumer<? super Character> action) {
    action.accept(string.charAt(currentChar++)); // 현재 문자를 소비한다.
    return currentChar < string.length(); // 소비할 문자가 남아있으면 true를 반환한다.
  }

  @Override
  public Spliterator<Character> trySplit() {
    int currentSize = string.length() - currentChar;
    if (currentSize < 10) { // 파싱할 문자열을 순차 처리할 수 있을 만큼 충분히 작아졌음을 알리는 null을 반환한다.
      return null;
    }
    for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
      if (Character.isWhitespace(string.charAt(splitPos))) { // 파싱할 문자열의 중간을 분할 위치로 설정한다. 단어 중간에 분할 위치가 오지 않도록 공백을 찾는다.
        Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos)); // 다음 문자부터 분할 위치까지 문자열을 파싱할 새로운 WordCounterSpliterator를 생성한다.
        currentChar = splitPos; // 이 WordCounterSpliterator의 시작 위치를 분할 위치로 설정한다.
        return spliterator; // 공백을 찾았고 문자열을 분할할 수 있으므로 새로운 Spliterator를 반환한다.
      }
    }
    return null; // 문자열을 분할할 수 없으면 null을 반환한다.
  }

  @Override
  public long estimateSize() {
    return string.length() - currentChar; // 이 Spliterator가 파싱할 문자열의 남은 문자 수를 반환한다.
  }

  @Override
  public int characteristics() {
    return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE; // ORDERED, SIZED, SUBSIZED, NONNULL, IMMUTABLE 특성을 갖는다.
  }
}
