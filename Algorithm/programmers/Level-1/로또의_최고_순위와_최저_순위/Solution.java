package 로또의_최고_순위와_최저_순위;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos,win_nums);
        for (int j : result) {
            System.out.println(j);
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winNumsSet = new HashSet<>();
        for (int winNum : win_nums) {
            winNumsSet.add(winNum);
        }

        int winNumCount = 0;
        int unknownNumCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                unknownNumCount++;
            } else if (winNumsSet.contains(lotto)) {
                winNumCount++;
            }
        }

        int highRank = Math.min(7 - (winNumCount + unknownNumCount), 6);
        int lowRank = Math.min(7 - winNumCount, 6);
        return new int[] {highRank, lowRank};
    }
}
