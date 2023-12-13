package ch13.sec05;

public class Course {
  //모든 사람 등록가능
  public static void registerCourse(Applicant<? super Person> applicant) {
    System.out.println("등록");
  }

  //학생 등록가능
  public static void registerCourseStudent(Applicant<? extends Student> applicant) {
    System.out.println("학생 등록");
  }

  //직장인 등록가능
  public static void registerCourseWorker(Applicant<? super Worker> applicant) {
    System.out.println("직장인 등록");
  }
}
