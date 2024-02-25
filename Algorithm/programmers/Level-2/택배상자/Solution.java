package 택배상자;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int cur = 0;

        for (int i = 1; i <= order.length; i++) {
            st.push(i);
            while (!st.isEmpty() && st.peek() == order[cur]) {
                st.pop();
                cur++;
                answer++;
            }
        }

        return answer;
    }
}
