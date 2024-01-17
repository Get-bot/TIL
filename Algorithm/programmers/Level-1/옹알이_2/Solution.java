package 옹알이_2;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        int result = solution(babbling);
        System.out.println("result = " + result);
    }

    public static int solution(String[] babbling) {
        return (int) Arrays.stream(babbling)
                .map(Solution::replaceWords)
                .filter(Solution::validateWord)
                .count();
    }

    private static String replaceWords(String word) {
        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < words.length; i++) {
            word = word.replaceAll(words[i], String.valueOf(i));
        }
        return word;
    }

    private static boolean validateWord(String word) {
        return word.matches("(?!.*?(\\d)\\1)\\d+");
    }


}
