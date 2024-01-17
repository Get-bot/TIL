package 가장_가까운_같은_글자;

public class Solution {
    public int[] solution(String s) {
        int sLength = s.length();
        int[] answer = new int[sLength];


        for(int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            int fromIndex = i - 1;
            if(s.lastIndexOf(c, fromIndex) == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - s.lastIndexOf(c, fromIndex);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "banana";
        int[] answer = solution.solution(s);
        System.out.println(answer);
    }
}
