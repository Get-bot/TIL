package ch09_리팩터링_테스팅_디버깅;

import classes.Point;

import java.util.Arrays;
import java.util.List;

public class Debugging {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12,2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }
}
