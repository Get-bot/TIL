package 숫자_짝궁;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String X = "1234567890000000000";
        String Y = "1000000000000000000000000000";
        String result = solution(X, Y);
        System.out.println("result = " + result);
    }

    public static String solution(String X, String Y) {
        Map<String, Long> frequencyInX = Arrays.stream(X.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> frequencyInY = Arrays.stream(Y.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> collect = new ArrayList<>();

        for (String digit : frequencyInX.keySet()) {
            if (frequencyInY.containsKey(digit)) {
                long minFrequency = Math.min(frequencyInX.get(digit), frequencyInY.get(digit));
                for (int i = 0; i < minFrequency; i++) {
                    collect.add(digit);
                }
            }
        }

        if (collect.isEmpty()) {
            return "-1";
        } else if (collect.stream().allMatch("0"::equals)) {
            return "0";
        } else {
            return collect.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        }
    }
}
