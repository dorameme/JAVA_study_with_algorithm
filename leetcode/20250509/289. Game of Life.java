/*
start:12:20
end:12:39
시간복잡도:O(NM)
공간복잡도:O(NM) -> O(1)
풀이: 더 개선된 풀이로 따로 배열 공간을 할당하지않고 그냥 board자체에 0 1 이 아닌 -1,2 등을 이용해 풀수있다!
우선 
board[i][j] ==1,2,3 -> 처음부터 1인애들
board[i][j] ==4 -> 처음엔 0인애들 로 표시해주고
board[i][j]를 수정할 때는 2면 0으로 3,4 인경우는 1로 바꾸어주면 된다!!
*/

//개선된 풀이
class Solution {
    int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
    int[] dy = { 1, -1, 0, 1, -1, 0, -1, 1 };

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = countNeighbors(i, j, board);
                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 2;//die
                    } else  {
                        board[i][j] = 3;//live
                    }
                } else {
                    if (cnt == 3) {
                        board[i][j] = 4;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j]>=3) {
                    board[i][j] = 1;
                }
            }
        }
        // board=vis;
    }

    int countNeighbors(int x, int y, int[][] b) {
        int cnt = 0;
        int n = b.length;
        int m = b[0].length;
        for (int i = 0; i < 8; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= m)
                continue;
            if (b[x + dx[i]][y + dy[i]] == 1  || b[x + dx[i]][y + dy[i]]==2||b[x + dx[i]][y + dy[i]]==3)
                cnt++;
        }
        return cnt;
    }
}
class Solution {
    int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
    int[] dy = { 1, -1, 0, 1, -1, 0, -1, 1 };

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = countNeighbors(i, j, board);
                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) {
                        vis[i][j] = 1;//die
                    } else  {
                        vis[i][j] = 2;//live
                    }
                } else {
                    if (cnt == 3) {
                        vis[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 2) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        // board=vis;
    }

    int countNeighbors(int x, int y, int[][] b) {
        int cnt = 0;
        int n = b.length;
        int m = b[0].length;
        for (int i = 0; i < 8; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= m)
                continue;
            if (b[x + dx[i]][y + dy[i]] == 1)
                cnt++;
        }
        return cnt;
    }
}
