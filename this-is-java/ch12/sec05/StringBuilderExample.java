package ch12.sec05;

public class StringBuilderExample {
  public static void main(String[] args) {
    String data = new StringBuilder()
        .append("Java")
        .append("Program Study")
        .delete(4, 15)
        .insert(4, "2")
        .toString();

    System.out.println("data = " + data);
  }
}
