package 크기가_작은_부분문자열;

import java.util.stream.IntStream;

public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();
        long pLong = Long.parseLong(p);


        for (int i = 0; i < tLength; i++) {
            if (i <= tLength - pLength && Long.parseLong(t.substring(i, i + pLength)) <= pLong) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String t = "1312312321";
        String p = "321";
        int answer = solution.solution(t, p);
        System.out.println(answer);
    }
}
