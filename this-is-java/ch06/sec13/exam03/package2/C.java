package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.A;

public class C {
    public C() {
        A a = new A();

        a.field1 = 1;
//        a.field2 = 1; // (x)
//        a.field3 = 1; // (x)

        a.method1();
//        a.method2(); // (x)
//        a.method3(); // (x)
    }
}
