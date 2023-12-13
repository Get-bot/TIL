package ch12.sec10;

public class PatternExample {
  public static void main(String[] args) {
    String regex = "(02|010)-\\d{3,4}-\\d{4}";
    String tel1 = "010-123-4567";

    boolean result = tel1.matches(regex);
    if(result) {
      System.out.println("정규식과 일치합니다.");
    } else {
      System.out.println("정규식과 일치하지 않습니다.");
    }

    String regex2 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
    String email = "hong@navercom";

    boolean result2 = email.matches(regex2);
    if(result2) {
      System.out.println("정규식과 일치합니다.");
    } else {
      System.out.println("정규식과 일치하지 않습니다.");
    }
  }
}
