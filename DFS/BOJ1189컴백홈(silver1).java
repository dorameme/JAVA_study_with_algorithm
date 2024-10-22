/*
 * start:11:49
 * end: 12:23
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이: Simple DFS, but I changed cnt, so the answer was not correct, I had to put cnt + 1 in the next DFS second parameter.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;
    static int R;
    static int C;
    static int K;

    static int[][] vis;
    static String[] map = new String[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = arr[0];
        C = arr[1];
        K = arr[2];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();//br.readLine() method will return String.
        }

        vis = new int[R][C];
        vis[R - 1][0] = 1;
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {
        if (cnt == K) {
            if (x == 0 && y == C - 1) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx].charAt(ny) == 'T') {
                continue;
            }
            if (vis[nx][ny] == 0) {
                vis[nx][ny] = 1;
                dfs(nx, ny, cnt + 1);//you should not use cnt++!! 
                vis[nx][ny] = 0;
            }
        }

    }
}
