package 같은_숫자는_싫어;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                answer[j] = arr[i];
                j++;
            }

            if(answer[j - 1] != arr[i]) {
                answer[j] = arr[i];
                j++;
            }
        }

        return Arrays.copyOfRange(answer,0, j);
    }
}
