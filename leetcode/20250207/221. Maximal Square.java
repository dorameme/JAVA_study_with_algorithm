/*
start: 12:42
end: 12:50

시간 복잡도: O(NM) (N: 행 개수, M: 열 개수)
 - 각 원소를 한 번씩 순회하며 최댓값을 갱신하므로 O(NM)이다.

공간 복잡도: O(NM)
 - 추가적인 2D 배열(`map`)을 사용하여 O(NM)의 공간이 필요하다.

풀이:
1. `matrix`의 원소를 `int` 형태로 변환하여 `map` 배열에 저장한다.
2. DP 방식으로 `map[i][j]`에 (i, j)를 우측 하단으로 하는 정사각형의 최대 변 길이를 저장한다.
   - `map[i][j] = min(map[i-1][j-1], map[i-1][j], map[i][j-1]) + 1`
   - 단, `matrix[i-1][j-1]`이 '1'인 경우에만 갱신.
3. 최댓값(`answer`)을 유지하면서 마지막에 `answer * answer` 반환.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0; // 빈 배열 처리
        
        int rows = matrix.length, cols = matrix[0].length;
        int answer = 0;
        int[][] map = new int[rows + 1][cols + 1]; // DP 배열 (0-padding 적용)

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    map[i][j] = min3(map[i - 1][j - 1], map[i - 1][j], map[i][j - 1]) + 1;
                    answer = Math.max(answer, map[i][j]); // 최댓값 갱신
                }
            }
        }
        return answer * answer; // 최대 정사각형의 넓이 반환
    }

    // 세 값의 최소값 반환
    private int min3(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
