package ch12.sec11.exam02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
  private String model;
  private String color;

  public Car() {
  }

  public Car(String model) {
    this.model = model;
  }
}
