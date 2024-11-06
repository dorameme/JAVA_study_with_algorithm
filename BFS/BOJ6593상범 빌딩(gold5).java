
/*
 * start:15:24
 * end:15:44
 * 시간복잡도:O(N*M*S)
 * 공간복잡도:O(N*M*S)
 * 풀이:  단순한 bfs문제였고 사실상 너무 쉬워서 왜 정답률이 낮은지 모르겠다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int S, N, M;
    static String[][] map;
    static int[][][] vis;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            S = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            if (S == 0) {
                return;
            }
            map = new String[S][N];
            vis = new int[S][N][M];
            int[] start = new int[3];
            int[] end = new int[3];
            for (int i = 0; i < S; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = br.readLine();
                    for (int k = 0; k < M; k++) {
                        if (map[i][j].charAt(k) == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                        if (map[i][j].charAt(k) == 'E') {
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                    }
                }
                br.readLine();
            }
            Queue<int[]> q = new LinkedList<>();
            q.add(start);
            vis[start[0]][start[1]][start[2]] = 1;
            boolean exit = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
//                cur.equals(end); 은 안되는이유?
                if (Arrays.equals(cur, end)) {
                    System.out.println("Escaped in " + (vis[cur[0]][cur[1]][cur[2]]-1) + " minute(s).");
                    exit = true;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int ns = cur[0] + dz[i];
                    int nx = cur[1] + dx[i];
                    int ny = cur[2] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || ns < 0 || ns >= S) {
                        continue;
                    }
                    if (map[ns][nx].charAt(ny) == '#' || vis[ns][nx][ny] != 0) {
                        continue;
                    }
                    vis[ns][nx][ny] = vis[cur[0]][cur[1]][cur[2]] + 1;
                    q.add(new int[]{ns, nx, ny});
                }
            }
            if (exit == false) {
                System.out.println("Trapped!");
            }

        }
    }
}
