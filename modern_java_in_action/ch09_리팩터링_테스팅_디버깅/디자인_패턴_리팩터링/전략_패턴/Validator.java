package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.전략_패턴;

public class Validator {
    private final ValidationStrategy strategy;
    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }
    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
