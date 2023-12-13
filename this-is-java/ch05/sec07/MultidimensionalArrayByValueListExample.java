package ch05.sec07;

public class MultidimensionalArrayByValueListExample {
    public static void main(String[] args) {
        //2차원 배열 선언
        int[][] scores = {
            { 90, 80, 70 },
            { 85, 90, 95 }
        };

        //배열의 길이
        System.out.println("1차원 배열의 길이 : " + scores.length);
        System.out.println("2차원 배열의 길이 : " + scores[0].length);
        System.out.println("2차원 배열의 길이 : " + scores[1].length);

        //첫번째 반의 세 번째 학생의 점수
        System.out.println("첫번째 반의 세 번째 학생의 점수 : " + scores[0][2]);
        //두번째 반의 두 번째 학생의 점수
        System.out.println("두번째 반의 두 번째 학생의 점수 : " + scores[1][1]);

        //첫번째 반의 평균 점수
        int class1Sum = 0;
        for(int i=0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        System.out.println("첫번째 반의 평균 점수 : " + (double) class1Sum / scores[0].length);

        //두번째 반의 평균 점수
        int class2Sum = 0;
        for(int i=0; i < scores[1].length; i++) {
            class2Sum += scores[1][i];
        }
        System.out.println("두번째 반의 평균 점수 : " + (double) class2Sum / scores[1].length);

        //전체 반의 평균 점수
        int totalSum = class1Sum + class2Sum;
        int totalLength = scores[0].length + scores[1].length;
        System.out.println("전체 반의 평균 점수 : " + (double) totalSum / totalLength);

    }
}
