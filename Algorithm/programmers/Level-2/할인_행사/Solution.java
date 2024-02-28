package 할인_행사;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println("solution(want,number,discount) = " + solution(want,number,discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> sliceMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                sliceMap.put(discount[j], sliceMap.getOrDefault(discount[j], 0) + 1);
            }

            if (mapsAreEqual(targetMap, sliceMap)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean mapsAreEqual(Map<String, Integer> mapA, Map<String, Integer> mapB) {
        if (mapA.size() != mapB.size()) return false;
        for (String key : mapA.keySet()) {
            if (!mapB.containsKey(key)) return false;
            if (!mapA.get(key).equals(mapB.get(key))) return false;
        }
        return true;
    }
}
