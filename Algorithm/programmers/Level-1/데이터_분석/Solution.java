package 데이터_분석;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getIndex(ext);
        int sortByIndex = getIndex(sort_by);

        return Arrays.stream(data)
                .filter(item -> item[extIndex] < val_ext)
                .sorted(Comparator.comparingInt(item -> item[sortByIndex]))
                .collect(Collectors.toList());
    }

    private int getIndex(String attribute) {
        return switch (attribute) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException("Invalid attribute");
        };
    }

    public static void main(String[] args) {

        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        Solution solution = new Solution();
        List<int[]> solution1 = solution.solution(data, ext, val_ext, sort_by);
        solution1.stream().forEach(e -> System.out.println(Arrays.toString(e)));
    }

}
