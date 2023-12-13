package ch12.sec07;

public class MathExample {
  public static void main(String[] args) {
    //큰 정수 또는 작은 정수 얻기
    double v1 = Math.ceil(5.3); //올림
    double v2 = Math.floor(5.3); //내림
    System.out.println("v1 = " + v1);
    System.out.println("v2 = " + v2);

    //큰값 또는 작은값 얻기
    double v3 = Math.max(v1, v2);
    double v4 = Math.min(v1, v2);
    System.out.println("v3 = " + v3);
    System.out.println("v4 = " + v4);

    //소수 이하 두자리 얻기
    double v5 = Math.random();
    double v6 = Math.rint(v5 * 100) / 100.0;
    System.out.println("v5 = " + v5);
    System.out.println("v6 = " + v6);

  }
}
