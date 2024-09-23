/*
start:15:20
end:15:36
시간복잡도:O(NM)
공간복잡도:O(NM)
풀이: 하필이면 변수를 잘못넣어서 계속 고전헀다. 문제조건을 제대로 이해하고 풀면 어려울것 없는 문제였다.
*/
class Solution {

    public int solution(int[][] board) {
        int time = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        int dir = 0;
        int dir2 = 0;
        while (time <= 10000) {
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            int nx2 = dx[dir2] + x2;
            int ny2 = dy[dir2] + y2;
            if(x==x2&& y==y2)return time;
            if (check(nx, ny, board) && check(nx2, ny2, board)) {
                dir = (dir + 1) % 4;
                dir2 = (dir2 + 1) % 4;
                time++;
                continue;
            } else if (check(nx, ny, board)) {
                dir = (dir + 1) % 4;
                time++;
                x2 = nx2;
                y2 = ny2;
                continue;
            } else if (check(nx2, ny2, board)) {
                dir2 = (dir2 + 1) % 4;
                time++;
                x = nx;
                y = ny;
                continue;
            } else {
                x = nx;
                y = ny;
                x2 = nx2;
                y2 = ny2;
                time++;
            }
        }
        return time;

    }

    public static boolean check(int x, int y, int[][] board) {
        return x >= 10 || y >= 10 || x < 0 || y < 0 || board[x][y] == 1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
