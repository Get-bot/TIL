package ch14.sec09.exam03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        long start = System.currentTimeMillis();

        for (int i = 1; i <= 10000; i++) {
            int finalI = i;

            Future<Integer> future = executorService.submit(() -> {
                int sum = 0;
                for (int j = 1; j <= finalI; j++) {
                    sum += j;
                }
                System.out.println(Thread.currentThread().getName() + " executes task.");
                return sum;
            });

            try {
                int sum = future.get();
                System.out.println("sum: " + sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        executorService.shutdown();

        long start2 = System.currentTimeMillis();

        for (int i = 1; i <= 10000; i++) {

            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            System.out.println(Thread.currentThread().getName() + " executes task.");
            System.out.println("sum: " + sum);
        }


        long end2 = System.currentTimeMillis();

        System.out.println("Time: " + (end - start));
        System.out.println("Time2: " + (end2 - start2));
    }
}
