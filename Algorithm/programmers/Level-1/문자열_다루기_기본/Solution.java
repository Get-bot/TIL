package 문자열_다루기_기본;

public class Solution {
    public static void main(String[] args) {
        String s = "a234";
        boolean result = solution(s);
        System.out.println("result = " + result);
    }

    public static boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.matches("[0-9]+");
    }
}
