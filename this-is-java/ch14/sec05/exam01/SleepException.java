package ch14.sec05.exam01;

import java.awt.*;

public class SleepException {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++) {
            toolkit.beep();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
