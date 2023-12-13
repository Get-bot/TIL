package ch13.sec05;

public class GenericExample {
  public static void main(String[] args) {

    Person person = new Person();

    Student student = new Student();

    Worker worker = new Worker();

    HighSchoolStudent highSchoolStudent = new HighSchoolStudent();

    MiddleSchoolStudent middleSchoolStudent = new MiddleSchoolStudent();
    //모든 사람이 신청간으
    Course.registerCourse(new Applicant<Person>(person));
    Course.registerCourse(new Applicant<Person>(student));
    Course.registerCourse(new Applicant<Person>(worker));
    Course.registerCourse(new Applicant<Person>(highSchoolStudent));
    Course.registerCourse(new Applicant<Person>(middleSchoolStudent));

    //학생만 신청가능
    Course.registerCourseStudent(new Applicant<Student>(student));
    Course.registerCourseStudent(new Applicant<Student>(highSchoolStudent));
    Course.registerCourseStudent(new Applicant<Student>(middleSchoolStudent));

    //직장인만 신청가능
    Course.registerCourseWorker(new Applicant<Worker>(worker));
    Course.registerCourseWorker(new Applicant<Person>(person));
  }
}
