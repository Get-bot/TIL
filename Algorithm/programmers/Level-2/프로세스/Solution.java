package 프로세스;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
    }

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            // {index, priority}
            queue.offer(new int[]{i, priorities[i]});
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean isHighest = true;

            for (int[] task : queue) {
                if (task[1] > current[1]) {
                    isHighest = false;
                    break;
                }
            }

            if (!isHighest) {
                queue.offer(current);
            } else {
                answer++;
                if (current[0] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
