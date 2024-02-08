package _2016년;

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        String result = solution(a, b);
        System.out.println("result = " + result);
    }

    public static String solution(int a, int b) {
        String[] dayString = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        LocalDate date = LocalDate.of(2016, a, b);
        return dayString[date.getDayOfWeek().ordinal()];
    }
}
