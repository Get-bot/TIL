package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.전략_패턴;

public class ValidatorExample {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);

        // 람다 표현식을 전달
        Validator numericValidator2 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b3 = numericValidator2.validate("aaaa");
        System.out.println(b3);

        Validator lowerCaseValidator2 = new Validator((String s) -> s.matches("\\d+"));
        boolean b4 = lowerCaseValidator2.validate("bbbb");
        System.out.println(b4);
    }
}
