package 숫자의_표현;

public class Solution {
    public static void main(String[] args) {
        int n = 15;
        int result = solution(n);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        int[] sum = new int[n + 1];
        sum[0] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }

        int count = 0;
        int startIdx = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = sum[i] - sum[startIdx];
            if (tmp == n) {
                count++;
                startIdx++;
                i = startIdx;
            } else if (tmp > n) {
                startIdx++;
                i = startIdx;
            }
        }

        return count;
    }
}
