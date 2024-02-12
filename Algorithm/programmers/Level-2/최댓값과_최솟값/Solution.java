package 최댓값과_최솟값;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String result = solution(s);
        System.out.println("result = " + result);
    }

    public static String solution(String s) {
        int[] a = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        return a[0] + " " + a[a.length - 1];
    }
}
