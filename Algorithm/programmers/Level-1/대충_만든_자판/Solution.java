package 대충_만든_자판;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int targetLength = targets.length;
        int[] answer = new int[targetLength];

        for (int i = 0; i < targetLength; i++) {
            String word = targets[i];
            int wordCount = 0;
            boolean isWordValid = true;

            for (int j = 0; j < word.length() && isWordValid; j++) {
                char targetChar = word.charAt(j);
                int minKeyPress = Integer.MAX_VALUE;

                for (int k = 0; k < keymap.length; k++) {
                    int keyIndex = keymap[k].indexOf(targetChar);
                    if (keyIndex != -1) {
                        minKeyPress = Math.min(minKeyPress, keyIndex + 1);
                    }
                }

                if (minKeyPress == Integer.MAX_VALUE) {
                    wordCount = -1;
                    isWordValid = false;
                } else {
                    wordCount += minKeyPress;
                }
            }

            answer[i] = wordCount;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        int[] answer = solution.solution(keymap, targets);
        System.out.println(Arrays.toString(answer));
    }
}
