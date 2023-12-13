package ch17.example.exam02;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Example {
  public static void main(String[] args) throws UnknownHostException {
    List<Member> memberList = new ArrayList<>();

    memberList.add(new Member("홍길동", 20));
    memberList.add(new Member("김수애", 25));
    memberList.add(new Member("신용권", 30));
    memberList.add(new Member("박수미", 35));

    OptionalDouble optionalDouble = memberList.stream()
        .mapToInt(Member::getAge)
        .average();

    if(optionalDouble.isPresent()) {
      System.out.println("평균 나이: " + optionalDouble.getAsDouble());
    } else {
      System.out.println("평균 나이: 0.0");
    }

    InetAddress ia = InetAddress.getByName("www.gachinet.co.kr");
    System.out.println(ia.getHostAddress());
    InetAddress[] ias = InetAddress.getAllByName("www.gachinet.co.kr");
    for(InetAddress i : ias) {
      System.out.println(i.getHostAddress());
    }
  }
}
