package 짝지어_제거하기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "baabaa";
        int result = solution(s);
        System.out.println("result = " + result);
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
