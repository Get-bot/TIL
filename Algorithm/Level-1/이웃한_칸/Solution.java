package 이웃한_칸;

public class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int boardLength = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for(int i = 0; i <= 3; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            if(hCheck >= 0 && hCheck < boardLength && wCheck >=0 && wCheck < boardLength) {
                if(board[h][w].equals(board[hCheck][wCheck])){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"},{"red", "red", "blue", "orange"},{"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        Solution solution = new Solution();
        solution.solution(board, h, w);
    }
}
