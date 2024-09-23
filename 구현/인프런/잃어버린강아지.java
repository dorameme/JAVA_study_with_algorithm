/*
start: 14:30
end:14:37
시간복잡도:O(K)
공간복잡도:O(K)
풀이: 너무 쉬운문제라 할말이.. 간단한 형태의 구현문제!
*/
import java.util.Arrays;

class Solution {

    public int[] solution(int[][] board, int k) {
        int x = 0, y = 0;
        int size = board.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        while (k > 0) {
            k--;
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if (nx < 0 || ny < 0 || nx >= size || ny >= size || board[nx][ny]==1) {
                dir = dir + 1 > 3 ? 0 : dir + 1;
                continue;
            }
            else{
                x=nx; y=ny;

            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
