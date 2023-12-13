package ch12.sec03.exam02;

public class Student {
  private int no;
  private String name;

  public Student(int no, String name) {
    this.no = no;
    this.name = name;
  }

  public int getNo() { return no; }
  public String getName() { return name; }

  // hashCode() 메소드 재정의
  @Override
  public int hashCode() {
    return no + name.hashCode();
  }

  // equals() 메소드 재정의
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Student target) {
      return no == target.getNo() && name.equals(target.getName());
    }
    return false;
  }
}
