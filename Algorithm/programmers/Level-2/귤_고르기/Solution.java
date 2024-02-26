package 귤_고르기;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 1;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int t : tangerine) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        values.addAll(counter.values());

        int maxSum = 0;
        while (!values.isEmpty()) {
            maxSum += values.poll();

            if (maxSum >= k) {
                return answer;
            }
            answer++;
        }

        return answer;
    }
}
