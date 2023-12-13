package ch02.sec02;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 0;
        byte var4 = 30;
        byte var5 = 127;
        //byte var6 = 128; //컴파일 에러 발생

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);

        //byte 타입의 변수는 -128 ~ 127까지의 정수만 저장할 수 있기 때문에
        //128은 저장할 수 없어 컴파일 에러가 발생한다.
    }
}
