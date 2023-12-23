package ch09_리팩터링_테스팅_디버깅;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ApplyingFunctionalInterfaces {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("ch09_리팩터링_테스팅_디버깅.ApplyingFunctionalInterfaces");

        /*
         * 조건부 연기 실행
         * */

        // 매번 로깅 메시지를 생성하는 코드
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Problem: " + generateDiagnostic());
        }

        //오버로드된 log 메서드
//        public void log(Level level, Supplier<String> msgSupplier) {
//            if (!isLoggable(level)) {
//                return;
//            }
//            LogRecord lr = new LogRecord(level, msgSupplier.get());
//            doLog(lr);
//        }

        // 람다 표현식을 사용해 로깅 메시지를 생성하는 코드
        logger.log(Level.FINER, () -> "Problem: " + generateDiagnostic());

        /*
         * 실행 어라운드
         * */

/*         기존 코드
        public static String processFile() throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                return br.readLine();
            }
        }

         함수형 인터페이스를 이용해 리팩터링한 코드
        public static String processFile(BufferedReaderProcessor p) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                return p.process(br);
            }
        }

         함수형 인터페이스를 이용해 리팩터링한 코드를 호출하는 코드
        String oneLine = processFile((BufferedReader br) -> br.readLine());*/



    }

    private static String generateDiagnostic() {
        return "This is a diagnostic message";
    }
}
