package n2_배열_자르기;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        int[] result = solution(n,left,right);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        for (int i = 0; i < answer.length; i++) {
            int y = (int)(left / n + 1);
            int x = (int)(left % n + 1);
            left++;
            answer[i] = Math.max(y, x);
        }

        return answer;
    }
}
