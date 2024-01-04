package classes;

import lombok.Data;

@Data
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }


}
