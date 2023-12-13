package ch06.sec08.exam02;

public class Computer {
    int sum(int ... sum) {
        int total = 0;
        for (int i : sum) {
            total += i;
        }
        return total;
    }
}
