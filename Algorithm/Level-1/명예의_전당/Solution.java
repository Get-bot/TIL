package 명예의_전당;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public int[] solution(int k, int[] score) {

        int scoreLength = score.length;
        int[] answer = new int[scoreLength];
        List<Integer> tempScore = new ArrayList<>();
        int minScore = Integer.MIN_VALUE;

        for(int i = 0; i < scoreLength; i++) {
            int currentScore = score[i];
            minScore = tempScore.stream().mapToInt(x -> x).min().orElse(0);
            if(currentScore >= minScore && tempScore.size() == k) {
                tempScore.remove((Integer) minScore);
            }

            if(currentScore >= minScore || tempScore.size() < k) {
                tempScore.add(currentScore);
            }

            answer[i] = tempScore.stream().mapToInt(x -> x).min().orElse(0);
        }

        return answer;
    }

    public int[] solutionPriorityQueue(int k, int[] score) {

        int scoreLength = score.length;
        int[] answer = new int[scoreLength];
        PriorityQueue<Integer> tempScore = new PriorityQueue<>();

        for(int i = 0; i < scoreLength; i++) {
            tempScore.add(score[i]);

            if(tempScore.size() > k) {
                tempScore.poll();
            }

            if(tempScore.peek() != null) {
                answer[i] = tempScore.peek();
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int[] score = {100, 30, 40, 150, 300, 200, 200};
        int[] answer = solution.solution(k, score);
        int[] answer2 = solution.solutionPriorityQueue(k, score);
        for(int sc: answer) {
            System.out.println("sc = " + sc);
        }
        for (int sc: answer2) {
            System.out.println("sc2 = " + sc);
        }
    }
}
