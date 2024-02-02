package 이상한_문자_만들기;

public class Solution {
    public static void main(String[] args) {
        String s = "try hello world";
        String result = solution(s);
        System.out.println("result = " + result);
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int wordCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if(character != ' ') {
                if(wordCount % 2 == 0) {
                   character = Character.toUpperCase(character);
                } else {
                    character = Character.toLowerCase(character);
                }
                wordCount++;
            }else {
                wordCount = 0;
            }
            answer.append(character);
        }

        return answer.toString();
    }
}
