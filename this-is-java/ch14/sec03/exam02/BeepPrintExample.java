package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Thread thread = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                toolkit.beep();
                try { Thread.sleep(500); } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        thread.start();

        for(int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
