package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
//        intArray[0] = 10; // NullPointerException 발생

        String data = null;
//        System.out.println(data.toString()); // NullPointerException 발생
    }
}
