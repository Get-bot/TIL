package 문자열_나누기;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();

        int firstCharIndex = 0;
        int sameCharCount = 0;
        int differentCharCount = 0;

        for(int i = 0; i < sLength; i++) {
            char firstChar = s.charAt(firstCharIndex);
            char currentChar = s.charAt(i);

            if(firstChar == currentChar) {
                sameCharCount++;
            } else {
                differentCharCount++;
            }

            if(sameCharCount == differentCharCount || i == sLength - 1) {
                firstCharIndex = i + 1;
                sameCharCount = 0;
                differentCharCount = 0;
                answer ++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abracadabra";
        int answer = solution.solution(s);
        System.out.println(answer);
    }
}
