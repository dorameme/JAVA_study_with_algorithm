/*
 * start:19;01
 * end:19:25
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이: 단순한 bfs + dp 문제

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] vis = new int[n][m];
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                vis[i][j]=-1;
            }
        }
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, map[0][0]});
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            answer = Math.max(cur[2], answer);
            for (int i = 0; i < 2; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                int plus = map[nx][ny] == 1 ? 1 : 0;
                if (vis[nx][ny] >= cur[2] + plus) {
                    continue;
                }
                vis[nx][ny] = cur[2] + plus;
                q.push(new int[]{nx, ny, cur[2] + plus});

            }
        }
        System.out.println(answer);
    }
}
