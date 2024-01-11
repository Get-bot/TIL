package 카드_뭉치;

import java.util.*;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Queue = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new LinkedList<>(Arrays.asList(cards2));

        for (String goalEl : goal) {
            if (!cards1Queue.isEmpty() && cards1Queue.peek().equals(goalEl)) {
                cards1Queue.poll();
            } else if (!cards2Queue.isEmpty() && cards2Queue.peek().equals(goalEl)) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = solution.solution(cards1, cards2, goal);
        System.out.println(answer);
    }
}
