package ch16.sec05.exam03;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
  private String id;
  private String name;

  public Member(String id) {
    this.id = id;
  }
}
