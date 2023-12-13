package ch12.sec03.exam04;

public class RecordExample {
  public static void main(String[] args) {
    Member member = new Member("blue", "홍길동", 25);
    System.out.println(member.id());
    System.out.println(member.name());
    System.out.println(member.age());
    System.out.println("member.toString() = " + member.toString());

    Member member2 = new Member("blue", "홍길동", 25);

    System.out.println("member.hashCode() = " + member.hashCode());
    System.out.println("member2.hashCode() = " + member2.hashCode());
    System.out.println("member.equals() = " + member.equals(member2));
  }
}
