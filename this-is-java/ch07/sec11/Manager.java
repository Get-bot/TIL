package ch07.sec11;

public non-sealed class Manager extends Person{
    @Override
    public void work() {
        System.out.println("일꾼을 감독합니다.");
    }
}
