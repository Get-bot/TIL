package ch11.sec02.exam02;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            Class.forName("java.lang.String");
            System.out.println("클래스가 존재합니다.");
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class.forName("java.lang.String2");
            System.out.println("클래스가 존재하지 않습니다.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
