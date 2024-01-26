package 체육복;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int result = solution(n, lost, reserve);
        System.out.println("result = " + result);
    }


    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        for (int r : reserve) {
            reserveSet.add(r);
        }

        int answer = n - lost.length;

        for (int l : lost) {
            if (reserveSet.contains(l)) {
                answer++;
                reserveSet.remove(l);
            } else {
                lostSet.add(l);
            }
        }


        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                answer++;
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                answer++;
                reserveSet.remove(l + 1);
            }
        }

        return answer;
    }
}
