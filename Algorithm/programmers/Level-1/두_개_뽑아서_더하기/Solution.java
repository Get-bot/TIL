package 두_개_뽑아서_더하기;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);
        for (int i : result) {
            System.out.println("i = " + i);
        }

    }

    public static int[] solution(int[] numbers) {
        Set<Integer> answer = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
