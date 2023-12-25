package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.팩토리_패턴;

import classes.factoryExample.Bond;
import classes.factoryExample.Loan;
import classes.factoryExample.Product;
import classes.factoryExample.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.팩토리_패턴.ProductFactory.createProduct;

public class ProductFactoryExample {
    public static void main(String[] args) {

        //팩토리 패턴을 사용하면 객체 생성을 캡슐화할 수 있다.
        Product loan = createProduct("loan");
        Product stock = createProduct("stock");
        Product bond = createProduct("bond");

        //람다 표현식을 사용하면 객체 생성을 캡슐화할 수 있다.
        Supplier<Product> loanSupplier = Loan::new;
        Product loan2 = loanSupplier.get();

    }

    //Map으로 코드 재구현
    public static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> p = map.get(name);
        if(p != null) return p.get();
        throw new IllegalArgumentException("No such product " + name);
    }
}
