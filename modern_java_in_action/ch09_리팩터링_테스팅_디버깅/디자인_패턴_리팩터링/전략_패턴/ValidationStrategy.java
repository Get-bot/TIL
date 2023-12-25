package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.전략_패턴;

public interface ValidationStrategy {
    boolean execute(String s);
}
