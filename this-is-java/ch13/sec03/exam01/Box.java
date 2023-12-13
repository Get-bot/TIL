package ch13.sec03.exam01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box<T> {
  private T t;
}
