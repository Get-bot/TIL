package 폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int pick = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        return Math.min(pick, set.size());
    }
}
