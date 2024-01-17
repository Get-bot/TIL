package 콜라_문제;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;
        int result = solution(a, b, n);
        System.out.println("answer = " + result);

    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        while (a <= n) {
            answer += n / a * b;
            n = n / a * b + n % a;
        }
        return answer;
    }
}
