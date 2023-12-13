package ch12.sec03.exam01;

public class Member {
  public String id;

  public Member(String id) {
    this.id = id;
  }

  // Object의 equals() 메소드를 재정의
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member target) {  // obj가 Member 타입인지 확인후 target에 대입
      return id.equals(target.id); // id 필드값이 동일한지 검사한 후 리턴
    }
    return false;
  }

}
