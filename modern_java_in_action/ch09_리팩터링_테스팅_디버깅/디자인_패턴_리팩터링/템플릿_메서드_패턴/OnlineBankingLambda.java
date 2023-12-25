package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.템플릿_메서드_패턴;

import classes.Customer;
import classes.Database;

import java.util.function.Consumer;

public class OnlineBankingLambda {
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}
