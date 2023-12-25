package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.옵저버_패턴;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
