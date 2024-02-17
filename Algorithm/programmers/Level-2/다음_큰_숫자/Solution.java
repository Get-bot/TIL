package 다음_큰_숫자;

public class Solution {
    public static void main(String[] args) {
        int n = 78;
        int result = solution(n);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        int bitCount = Integer.bitCount(n);
        while (true) {
            n++;
            if (Integer.bitCount(n) == bitCount) {
                return n;
            }
        }
    }
}
