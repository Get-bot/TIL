package ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {
        int var1 = 10;
        byte var2  = (byte)var1; // int(4byte) -> byte(1byte)
        System.out.println("var2 = " + var2);

        long var3 = 300;
        int var4 = (int)var3; // long(8byte) -> int(4byte)
        System.out.println("var4 = " + var4);

        int var5 = 65;
        char var6 = (char)var5; // int(4byte) -> char(2byte)
        System.out.println("var6 = " + var6);

        double var7 = 3.14;
        int var8 = (int)var7; // double(8byte) -> int(4byte)
        System.out.println("var8 = " + var8);

        //실행결과
        //var2 = 10
        //var4 = 300
        //var6 = A
        //var8 = 3
    }
}
