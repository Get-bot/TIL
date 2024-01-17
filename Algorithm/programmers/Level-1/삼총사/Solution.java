package 삼총사;

public class Solution {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        int result = solution(number);
        System.out.println("result = " + result);
    }

    public static int solution(int[] number) {
        return comb(0, 0, 0, number);
    }

    private static int comb(int cur, int cnt, int sum, int[] number) {
        if (cnt == 3) {
            return sum == 0 ? 1 : 0;
        }

        int answer = 0;
        for (int i = cur; i < number.length; i++) {
            answer += comb(i + 1, cnt + 1, sum + number[i], number);
        }

        return answer;
    }
}
