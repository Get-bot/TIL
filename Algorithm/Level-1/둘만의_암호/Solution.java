package 둘만의_암호;

import java.util.*;

public class Solution {

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (char c : s.toCharArray()) {
            char addChar = c;
            for (int i = 1; i <= index; i++) {
                addChar++;
                if (addChar > 'z') {
                    addChar = 'a';
                }
                if (skipSet.contains(addChar)) {
                    i--;
                }
            }
            answer.append(addChar);
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String answer = solution.solution(s, skip, index);
        System.out.println(answer);
    }
}
