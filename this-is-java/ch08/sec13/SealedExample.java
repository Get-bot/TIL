package ch08.sec13;

public class SealedExample {
    public static void main(String[] args) {
        ImplClass impl = new ImplClass();

        InterfaceA ia = impl;
        ia.methodA();

        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        ib.methodA();

        System.out.println();

        InterfaceC ic = impl;
        ic.methodC();
        ic.methodB();
        ic.methodA();
    }
}
