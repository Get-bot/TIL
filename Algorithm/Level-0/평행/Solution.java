package 평행;

public class Solution {
    public int solution(int[][] dots) {
        if (areParallel(dots[0], dots[1], dots[2], dots[3]) ||
                areParallel(dots[0], dots[2], dots[1], dots[3]) ||
                areParallel(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean areParallel(int[] point1, int[] point2, int[] point3, int[] point4) {
        Double slope1 = calculateSlope(point1, point2);
        Double slope2 = calculateSlope(point3, point4);

        return slope1.equals(slope2);
    }

    private Double calculateSlope(int[] point1, int[] point2) {
        return (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
    }
}
