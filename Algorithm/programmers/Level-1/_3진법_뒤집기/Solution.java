package _3진법_뒤집기;

public class Solution {
    public static void main(String[] args) {
        int n = 45;
        int result = solution(n);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        String temp = "";

        while(n > 0){
            temp = (n % 3) + temp;
            n /= 3;
        }
        temp = new StringBuilder(temp).reverse().toString();

        return Integer.parseInt(temp,3);
    }
}
