package ch02.sec07;

public class PromotionExample {
    public static void main(String[] args) {
        //자동 타입 변환
        byte byteValue = 10;
        int intValue = byteValue; //int <- byte
        System.out.println(intValue);

        char charValue = '가';
        intValue = charValue; //int <- char
        System.out.println("가의 유니코드=" + intValue);

        intValue = 50;
        long longValue = intValue; //long <- int
        System.out.println(longValue);

        longValue = 100;
        float floatValue = longValue; //float <- long
        System.out.println(floatValue);

        floatValue = 100.5F;
        double doubleValue = floatValue; //double <- float
        System.out.println(doubleValue);

    }
}
