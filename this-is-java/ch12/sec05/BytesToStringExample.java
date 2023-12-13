package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {
  public static void main(String[] args) throws UnsupportedEncodingException {
    String data = "자바";

    //String -> byte[] normal UTF-8
    byte[] bytes = data.getBytes();
    System.out.println("bytes.length: " + bytes.length);
    System.out.println("Arrays.toString() = " + Arrays.toString(bytes));

    //byte[] -> String normal UTF-8
    String str1 = new String(bytes);
    System.out.println("str1 = " + str1);

    //String -> byte[] EUC-KR
    try {
      bytes = data.getBytes("EUC-KR");
      System.out.println("bytes.length: " + bytes.length);
      System.out.println("Arrays.toString() = " + Arrays.toString(bytes));
    } catch (Exception e) {
      System.err.println("Unsupported Encoding");
      e.printStackTrace();
    }

    //byte[] -> String EUC-KR
    String str2 = new String(bytes, "EUC-KR");
    System.out.println("str2 = " + str2);

    String str3 = new String(bytes);
    System.out.println("str3 = " + str3);


  }
}
