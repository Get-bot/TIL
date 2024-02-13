package JadenCase_문자열_만들기;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String result = solution(s);
        System.out.println("result = " + result);
    }

    public static String solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ", -1);

        for (String word : words) {
            System.out.println("word = " + word);
            if (!word.isEmpty() && Character.isAlphabetic(word.charAt(0))) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
            } else {
                result.append(word.toLowerCase());
            }
            result.append(" ");
        }

        return !result.isEmpty() ? result.substring(0, result.length() - 1) : result.toString();
    }
}
