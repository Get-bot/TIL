package 모의고사;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = solution(answers);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    static int[] num1Answer = {1, 2, 3, 4, 5};
    static int[] num2Answer = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] num3Answer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static int[] solution(int[] answers) {
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (num1Answer[i % num1Answer.length] == answers[i]) {
                score[0]++;
            }
            if (num2Answer[i % num2Answer.length] == answers[i]) {
                score[1]++;
            }
            if (num3Answer[i % num3Answer.length] == answers[i]) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> bestMatches = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) {
                bestMatches.add(i + 1);
            }
        }

        return bestMatches.stream().mapToInt(i -> i).toArray();
    }
}
