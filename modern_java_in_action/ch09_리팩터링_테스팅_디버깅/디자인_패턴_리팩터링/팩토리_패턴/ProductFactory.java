package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.팩토리_패턴;

import classes.factoryExample.Bond;
import classes.factoryExample.Loan;
import classes.factoryExample.Product;
import classes.factoryExample.Stock;

public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }
}
