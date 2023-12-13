package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
  public static void main(String[] args) {
    String text = "홍길동/이수홍/박연수";
    String[] names = text.split("/");
    for (String name : names) {
      System.out.println(name);
    }

    text = "홍길동&이수홍,박연수";
    names = text.split("[&,-]");
    for (String name : names) {
      System.out.println(name);
    }

     String text2 = "홍길동/이수홍/박연수";
     StringTokenizer st = new StringTokenizer(text, "/");
     int countTokens = st.countTokens();
     for (int i = 0; i < countTokens; i++) {
       String token = st.nextToken();
       System.out.println(token);
     }
  }
}
