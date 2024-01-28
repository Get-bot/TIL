package 완주하지_못한_선수;

import java.util.Arrays;
public class Solution {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String result = solution(participant, completion);
        System.out.println("result = " + result);
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for (i = 0; i < completion.length; i++)
            if (!participant[i].equals(completion[i]))
                break;

        return participant[i];
    }
}
