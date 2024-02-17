package 이진_변환_반복하기;

public class Solution {
    public static void main(String[] args) {
        String s = "110010101001";
        int[] result = solution(s);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;

        while (!s.equals("1")) {
            int lengthBefore = s.length();

            s = s.replaceAll("0", "");
            int lengthAfter = s.length();

            zeroCnt += (lengthBefore - lengthAfter);

            s = Integer.toBinaryString(lengthAfter);

            cnt++;
        }

        return new int[]{cnt, zeroCnt};
    }
}
