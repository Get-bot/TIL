package ch12.sec04;

public class GetPropertyExample {
  public static void main(String[] args) {
    String osName = System.getProperty("os.name");
    String userName = System.getProperty("user.name");
    String userHome = System.getProperty("user.home");

    System.out.println("운영체제 이름: " + osName);
    System.out.println("사용자 이름: " + userName);
    System.out.println("사용자 홈디렉토리: " + userHome);

    //전체 키와 값을 출력
    System.getProperties().list(System.out);
  }
}
