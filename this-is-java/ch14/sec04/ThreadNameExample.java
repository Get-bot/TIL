package ch14.sec04;

public class ThreadNameExample {
    public static void main(String[] args) {
        // 스레드 객체 참조 얻기
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 스레드가 실행");

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 스레드가 실행");
                }
            };
            thread.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 스레드가 실행");
            }
        };
        chatThread.setName("채팅 스레드");
        chatThread.start();
    }

}
