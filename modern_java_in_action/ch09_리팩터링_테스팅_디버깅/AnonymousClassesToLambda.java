package ch09_리팩터링_테스팅_디버깅;

public class AnonymousClassesToLambda {
    public static void main(String[] args) {

        // 익명 클래스
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        // 람다 표현식으로 변환
        Runnable r2 = () -> System.out.println("Hello");

        //람다는 익명 클래스와 달리 쉐도윙을 허용하지 않는다.
        int a = 10;
        Runnable r3 = () -> {
            // a = 20; // 컴파일 에러
            System.out.println("Hello");
        };

        Runnable a4 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };

        //익명 클래스 콘텍스트 전달
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

        //람다 표현식 콘텍스트 전달
        doSomething((Task) () -> System.out.println("Danger danger!!"));


    }

    public interface Task {
        public void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }
}
