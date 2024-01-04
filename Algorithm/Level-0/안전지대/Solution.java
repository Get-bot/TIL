package 안전지대;

import java.util.Arrays;

public class Solution {
    public long solution(int[][] board) {

        // 보드의 행과 열의 길이를 가져옵니다.
        int boardRows = board.length;
        int boardCols = board[0].length;

        // 새로운 배열의 크기를 정의합니다. 기존 배열보다 각각의 차원에서 2씩 큽니다.
        int newRows = boardRows + 2;
        int newCols = boardCols + 2;
        int[][] newArray = new int[newRows][newCols];

        // 새로운 배열에 값을 채웁니다.
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                // 배열의 가장자리(테두리)에는 3을 채웁니다.
                if (i == 0 || i == newRows - 1 || j == 0 || j == newCols - 1) {
                    newArray[i][j] = 3;
                } else {
                    // 기존 배열의 값을 새로운 배열의 가운데에 복사합니다.
                    newArray[i][j] = board[i - 1][j - 1];
                }
            }
        }

        // 1의 값을 갖는 요소 주변에 0이 있다면 그 값을 2로 변경합니다.
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                if (newArray[i][j] == 1) {
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if (newArray[i + k][j + l] == 0) {
                                newArray[i + k][j + l] = 2;
                            }
                        }
                    }
                }
            }
        }

        // 최종적으로, 0의 개수를 세어 반환합니다.
        return Arrays.stream(newArray)
                .flatMapToInt(Arrays::stream)
                .filter(num -> num == 0)
                .count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        solution.solution(board);

    }
}
