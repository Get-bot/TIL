package 겹치는_선분의_길이;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        // 선분의 각 점을 키로 저장하고 각 점이 선분에 포함된 횟수를 값으로 저장
        for (int[] line : lines) {
            int from = Math.min(line[0], line[1]);
            int to = Math.max(line[0], line[1]);
            for (int i = from; i < to; i++) { // 선분의 시작점에서 끝점 바로 직전까지 반복
                map.merge(i, 1, Integer::sum);
                // 포인트가 이미 맵에 있는 경우 해당 값(개수)이 1씩 증가하고 맵에 없는 경우 1로 추가
            }
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
        // 1보다 큰 값만 유지하고 개수를 세어 반환
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] lines = {{1, 4}, {3, 4}, {3, 10}};
        System.out.println(solution.solution(lines));
    }

}
