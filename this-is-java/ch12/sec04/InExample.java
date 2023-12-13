package ch12.sec04;

import java.io.IOException;

public class InExample {
  public static void main(String[] args) throws IOException {
    int speed = 0;
    int keyCode = 0;

    while (true)  {
      if(keyCode != 13 && keyCode != 10) {
        System.out.println("-----------------------------");
        System.out.println("1. 증속 | 2. 감속 | 3. 중지");
        System.out.println("-----------------------------");
        System.out.print("선택: ");
      }

      keyCode = System.in.read();

      if (keyCode == 49) {
        speed++;
        System.out.println("현재 속도=" + speed);
      } else if (keyCode == 50) {
        speed--;
        System.out.println("현재 속도=" + speed);
      } else if (keyCode == 51) {
        break;
      }
    }
  }
}
