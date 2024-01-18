package 최소직사각형;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};
        int result = solution(sizes);
        System.out.println("result = " + result);
    }

    public static int solution(int[][] sizes) {
        int maxFirst = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;

        for (int[] subArray : sizes) {
            if (subArray[0] < subArray[1]) {
                int temp = subArray[0];
                subArray[0] = subArray[1];
                subArray[1] = temp;
            }

            if (subArray[0] > maxFirst) {
                maxFirst = subArray[0];
            }
            if (subArray[1] > maxSecond) {
                maxSecond = subArray[1];
            }
        }

        return maxFirst * maxSecond;
    }
}
