/*
 * start:22:35
 * end:22:58
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이: It was a BFS issue. It's so simple, it's self-explanatory.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] vis = new int[s[1]][s[0]];
        int W = 0;
        int B = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        String[] map = new String[s[1]];
        for (int i = 0; i < s[1]; i++) {
            map[i] = br.readLine();
        }

        for (int i = 0; i < s[1]; i++) {
            for (int j = 0; j < s[0]; j++) {
                if (vis[i][j] == 0) {
                    int cnt = 1;
                    LinkedList<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    vis[i][j] = 1;

                    while (!q.isEmpty()) {
                        int[] cur = q.pop();
                        for (int z = 0; z < 4; z++) {
                            int nx = dx[z] + cur[0];
                            int ny = dy[z] + cur[1];
                            if (nx < 0 || ny < 0 || nx >= s[1] || ny >= s[0] || vis[nx][ny] == 1
                                || map[i].charAt(j) != map[nx].charAt(ny)) {
                                continue;
                            }
                            vis[nx][ny] = 1;
                            cnt++;
                            q.add(new int[]{nx, ny});
                        }
                    }
                    if (map[i].charAt(j) == 'W') {
                        W += cnt * cnt;
                    } else {
                        B += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }
}

