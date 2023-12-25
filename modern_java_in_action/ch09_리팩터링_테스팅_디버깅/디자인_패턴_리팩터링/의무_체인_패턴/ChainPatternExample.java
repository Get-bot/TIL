package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.의무_체인_패턴;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainPatternExample {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result1 = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result1);
        //result1 = "From Raoul, Mario and Alan: Aren't lambdas really sexy?!!"

        // 람다 표현식을 사용한 예제
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);
        //result2 = "From Raoul, Mario and Alan: Aren't lambdas really sexy?!!"
    }
}
