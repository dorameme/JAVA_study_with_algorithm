/**
start:4:50
end:5:10
시간복잡도: O(nm)
공간복잡도:O(nm)
풀이: DFS로 간단히 구현가능했던 문제!
**/
class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] vis = new int[301][301];

    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(int x, int y, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                continue;
            }
            System.out.println(grid[nx][ny]);
            if (grid[nx][ny] == '1') {
                grid[nx][ny] = '0';
                dfs(nx, ny, grid);
            }
        }
    }
}

