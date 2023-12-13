package ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void main(String[] args) {
        //배열 변수 선언
        int[] scores;
        //배열 변수에 배열을 대입
        scores = new int[] {83, 90, 87};
        //배열 항목의 총합을 구하고 출력
        int sum1 = 0;
        for(int i=0; i < 3; i++) {
            sum1 += scores[i];
        }
        System.out.println("총합 : " + sum1);

        //배열을 매개값으로 주고, printItem() 메소드 호출
        printItems(new int[] {83, 90, 87});
    }

    public static void printItems(int[] scores) {
        //배열 항목의 총합을 구하고 출력
        int sum2 = 0;
        for(int i=0; i < 3; i++) {
            sum2 += scores[i];
        }
        System.out.println("총합 : " + sum2);
    }
}
