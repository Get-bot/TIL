package ch07_병렬_데이터_처리와_성능;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomSpliterator {
  public static void main(String[] args) {
    System.out.println("Found " + countWordsIteratively("Go to the hell") + " words");

    String sentence = " Nel   mezzo del cammin  di nostra  vita " +
        "mi  ritrovai in una  selva oscura" +
        " ché la  dritta via era   smarrita ";

    System.out.println("Found " + countWordsIteratively(sentence) + " words");

    //함수형
    Stream<Character> stream = IntStream.range(0, sentence.length())
        .mapToObj(sentence::charAt);

    System.out.println("Found " + countWords(stream.parallel()) + " words");

    //병렬 스트림

  }

  public static int countWordsIteratively(String s) {
    int counter = 0;
    boolean lastSpace = true;
    for (char c : s.toCharArray()) { // 문자열을 하나씩 탐색
      if (Character.isWhitespace(c)) {
        lastSpace = true;
      } else {
        if (lastSpace) counter++; // 단어의 첫 글자일 경우 카운터 증가
        lastSpace = false;
      }
    }
    return counter;
  }

  @Getter
  @AllArgsConstructor
  static class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter accumulate(Character c) { // 문자를 하나씩 탐색할 때마다 호출
      if (Character.isWhitespace(c)) { // 공백 문자 확인
        return lastSpace ? this : new WordCounter(counter, true);
      } else {
        return lastSpace ? new WordCounter(counter + 1, false) : this; // 문자를 하나씩 탐색하다 공백 문자를 만나면 지금까지 탐색한 문자를 단어로 간주해 카운터를 증가
      }
    }

    public WordCounter combine(WordCounter wordCounter) {
      return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);  // 두 WordCounter의 counter 값을 더함,
    }
  }

  private static int countWords(Stream<Character> stream) {
    WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
    return wordCounter.getCounter();
  }
}
