package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.템플릿_메서드_패턴;

import classes.Customer;

public class OnlineBankingExample {
    public static void main(String[] args) {

        //템플릿 메서드를 사용한 예제
        new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println("Hello " + c.getName());
            }
        }.processCustomer(1337);

        //람다 표현식을 사용한 예제
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello " + c.getName()));
    }
}
