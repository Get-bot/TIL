package 기능개발;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        List<Integer> answer = solution(progresses, speeds);
        System.out.println(answer.toString());
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // Calculate the days to finish and add to the queue
            days.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!days.isEmpty()) {
            int day = days.poll();
            int count = 1;

            while (!days.isEmpty() && days.peek() <= day) {
                days.poll();
                count++;
            }

            answer.add(count);
        }
        return answer;
    }
}
