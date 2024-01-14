package 햄버거_만들기;

import java.util.Stack;

public class Solution {
    public int solution(int[] ingredient) {
        int burgersWrapped = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 1) == 1 &&
                        stack.get(stack.size() - 2) == 3 &&
                        stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 4) == 1) {
                    burgersWrapped++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        return burgersWrapped;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int solution1 = solution.solution(ingredient);
        System.out.println("solution1 = " + solution1);
    }
}
