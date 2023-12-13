package ch15.sec06.exam02;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Message {
  private String command;
  private String to;

}
