
/*
 * start:12:14
 * end:12:26
 * 시간복잡도:O(N*M)
 * 공간복잡도:O(N*M)
 * 풀이:it was just a simple BFS problem
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr[0];
        M = arr[1];
        K = arr[2];
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            int[] k = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[k[0] - 1][k[1] - 1] = 1;
        }
        int vis[][] = new int[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] == 0 && map[i][j] == 1) {
                    vis[i][j] = 1;
                    LinkedList<int[]> list = new LinkedList<>();
                    list.add(new int[]{i, j});
                    int cnt = 0;
                    while (!list.isEmpty()) {
                        int[] cur = list.removeFirst();
                        cnt++;
                        for (int z = 0; z < 4; z++) {
                            int nx = cur[0] + dx[z];
                            int ny = cur[1] + dy[z];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || vis[nx][ny] == 1
                                || map[nx][ny] == 0) {
                                continue;
                            }
                            vis[nx][ny] = 1;
                            list.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt > answer) {
                        answer = cnt;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
