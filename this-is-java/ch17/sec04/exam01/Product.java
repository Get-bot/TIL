package ch17.sec04.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Product {
  private long id;
  private String name;
  private String company;
  private int price;
}
