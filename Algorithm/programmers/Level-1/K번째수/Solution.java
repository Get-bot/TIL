package K번째수;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        int[] result = solution(array, commands);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] tempArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tempArr);
            answer[i] = tempArr[command[2] - 1];
        }
        return answer;
    }
}
