package 시저_암호;

public class Solution {
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        String result = solution(s, n);
        System.out.println("result = " + result);
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }
            answer.append(c);
        }

        return answer.toString();
    }
}
