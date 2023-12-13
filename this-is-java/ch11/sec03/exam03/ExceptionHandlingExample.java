package ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "] = " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스를 초과했음");
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("데이터에 문제가 있음." + e.getMessage());
            }
        }
    }
}
