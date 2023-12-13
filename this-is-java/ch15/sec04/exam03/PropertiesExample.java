package ch15.sec04.exam03;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
  public static void main(String[] args) throws IOException {
    // Properties 컬렉션 생성
    Properties properties = new Properties();

    // PropertiesExample.class와 동일한 ClassPath에 있는 파일을 읽어서 Properties 객체에 저장
    properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

    // Properties 객체에 저장된 객체들을 하나씩 읽어와서 출력
    String driver = properties.getProperty("driver");
    String url = properties.getProperty("url");
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");
    String admin = properties.getProperty("admin");

    // Properties 객체에 저장된 객체들을 하나씩 출력
    System.out.println("driver: " + driver);
    System.out.println("url: " + url);
    System.out.println("username: " + username);
    System.out.println("password: " + password);
    System.out.println("admin: " + admin);
  }
}
