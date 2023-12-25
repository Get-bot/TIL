package ch09_리팩터링_테스팅_디버깅.디자인_패턴_리팩터링.의무_체인_패턴;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
