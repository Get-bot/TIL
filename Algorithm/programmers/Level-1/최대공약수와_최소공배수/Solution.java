package 최대공약수와_최소공배수;

public class Solution {
    public static void main(String[] args) {

    }

    //유클리드 호제법
    public static int gcd(int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        // 두 수에서 더 큰 수를 n으로 지정
        if(n < m) {
            int tempNum = n;
            n = m;
            m = tempNum;
        }

        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }
}
