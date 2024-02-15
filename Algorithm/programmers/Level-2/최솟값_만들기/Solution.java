package 최솟값_만들기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
}
