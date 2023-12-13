package ch12.sec08;

public class PrintTimeZoneID {
  public static void main(String[] args) {
    String[] availableIDs = java.util.TimeZone.getAvailableIDs();
    for (String id : availableIDs) {
      System.out.println(id);
    }
  }
}
