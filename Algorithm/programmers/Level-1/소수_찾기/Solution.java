package 소수_찾기;

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        int result = solution(n);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return primeCount;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
