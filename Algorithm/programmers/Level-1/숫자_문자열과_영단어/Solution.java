package 숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);
        System.out.println("result = " + result);
    }

    static String[] wordArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static int solution(String s) {
        for(int i = 0; i < wordArr.length; i++ ) {
            s = s.replaceAll(wordArr[i], String.valueOf(i));
            if(s.matches("\\d+")) break;
        }

        return Integer.parseInt(s);
    }
}
