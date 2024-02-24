package 피로도;

public class Solution {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        return dfs(dungeons, new boolean[dungeons.length], k, 0, 0);
    }

    private static int dfs(int[][] dungeons, boolean[] visited, int tired, int maxCnt, int cnt) {
        int m = maxCnt;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && tired >= dungeons[i][0]) {
                visited[i] = true;
                m = dfs(dungeons, visited, tired - dungeons[i][1], m, cnt + 1);
                visited[i] = false;
            }
        }
        return Math.max(m, cnt);
    }
}
