package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.전략_패턴;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
