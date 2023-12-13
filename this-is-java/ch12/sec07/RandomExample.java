package ch12.sec07;

import java.util.Random;

public class RandomExample {
  public static void main(String[] args) {
    int[] selectNumber = new int[6];
    Random random = new Random(5);
    System.out.print("선택 번호: ");
    for (int i = 0; i < 6; i++) {
      selectNumber[i] = random.nextInt(45) + 1;
      System.out.print(selectNumber[i] + " ");
    }
    System.out.println();

    int[] winningNumber = new int[6];
    random = new Random(5);
    System.out.print("당첨 번호: ");
    for (int i = 0; i < 6; i++) {
      winningNumber[i] = random.nextInt(45) + 1;
      System.out.print(winningNumber[i] + " ");
    }

    System.out.println();

    int match = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++)
        if (selectNumber[i] == winningNumber[j]) {
          match++;
        }
    }

    System.out.println("일치 갯수: " + match);
  }
}

