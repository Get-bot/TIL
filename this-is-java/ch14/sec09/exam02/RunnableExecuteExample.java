package ch14.sec09.exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
    public static void main(String[] args) {
        List<List<String>> mailsList = new ArrayList<>();

        String[][] mails = new String[1000][3];

        for (int i = 0; i < mails.length; i++) {
            String[] mail = new String[3];
            mail[0] = "mail@" + i + ".com";
            mail[1] = "title" + i;
            mail[2] = "content" + i;
            mailsList.add(Arrays.asList(mail));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        long start = System.currentTimeMillis();

        for (List<String> mail : mailsList) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " sends " + mail.get(0)));
        }

        long end = System.currentTimeMillis();

        executorService.shutdown();

        long time = end - start;

        long start2 = System.currentTimeMillis();

        for (List<String> mail : mailsList) {
            System.out.println(Thread.currentThread().getName() + " sends " + mail.get(0));
        }

        long end2 = System.currentTimeMillis();

        long time2 = end2 - start2;


        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("All mails sent.");
                break;
            }
        }

        System.out.println("Time: " + time);
        System.out.println("Time2: " + time2);

    }
}