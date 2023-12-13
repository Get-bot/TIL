package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
  public static void main(String[] args) {
    List<Product> productList = new ArrayList<>();

    for(int i=1; i<=1000; i++) {
      productList.add(new Product(i, "Product" + i, "Company" + i, i*100));
    }

    Stream<Product> stream = productList.stream();
    stream.forEach(System.out::println);
  }
}
