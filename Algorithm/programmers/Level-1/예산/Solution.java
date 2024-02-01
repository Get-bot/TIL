package 예산;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        int result = solution(d, budget);
        System.out.println("result = " + result);
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int num : d) {
            if(budget < num) {
                break;
            }
            budget -= num;
            answer++;
        }

        return answer;
    }
}
