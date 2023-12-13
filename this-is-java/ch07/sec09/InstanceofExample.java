package ch07.sec09;

public class InstanceofExample {
    public static void personInfo(Person person) {
        System.out.println("name : " + person.name);
        person.walk();

        /*if (person instanceof Student){
            //Student 객체일 경우 강제 타입 변환
            Student student = (Student) person;
            //Student 객체만 가지고 있는 필드 및 메소드 사용
            System.out.println("studentNo : " + student.studentNo);
            student.study();
        }
        */

        //person이 참조하는 객체가 Student인지 확인
        //student 변수에 Student 객체를 대입
        if(person instanceof Student student) {
            System.out.println("studentNo : " + student.studentNo);
            student.study();
        }
    }

    public InstanceofExample() {
    }

    public static void main(String[] args) {
        //Person 객체를 매개값으로 제공하고 psesonInfo() 메소드 호출
        Person p1 = new Person("일반인");
        personInfo(p1);

        System.out.println();

        //Student 객체를 매개값으로 제공하고 psesonInfo() 메소드 호출
        Person p2 = new Student("학생", 123);
        personInfo(p2);

    }
}
