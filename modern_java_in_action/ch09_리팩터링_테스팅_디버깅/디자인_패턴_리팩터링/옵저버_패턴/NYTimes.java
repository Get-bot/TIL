package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.옵저버_패턴;

public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
