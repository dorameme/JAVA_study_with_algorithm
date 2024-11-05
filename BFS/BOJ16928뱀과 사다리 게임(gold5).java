/*
 * start:12:50
 * end:13:05
 * 시간복잡도: O(V + E) ≈ O(100 * 6) = O(600)
 * 공간복잡도:O(v) O(100)
 * 풀이: bfs가 너비우선탐색으로 더 적절하긴한데..
 나는 근데 dfs로 풀긴했음 ㅋㅋ 그게더 편함
DFS는 백트래킹을 통해 answer보다 큰 경로는 가지치기
하지만 더 긴 경로도 일단 탐색하다가 가지치기를 하므로 불필요한 탐색이 있을 수 있음
BFS는 레벨 순서대로 탐색하므로 처음 도착한 경로가 항상 최단 경로
불필요한 긴 경로 탐색을 하지 않음
효율성 고려하면 BFS queue쓰자.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, M;
    static int[] map = new int[101];
    static int answer = Integer.MAX_VALUE;
    static int[] dp = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        M = s[1];
        for (int i = 0; i < N + M; i++) {
            int[] move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            map[move[0]] = move[1];
        }
        solve(1, 0);
        System.out.println(answer);
    }

    public static void solve(int x, int moved) {
        if (moved >= answer) {
            return;
        } else if (x == 100) {
            answer = Math.min(answer, moved);
            return;
        }
        if (dp[x] != 0 && dp[x] <= moved) {
            return;
        }
        dp[x] = moved;
        for (int i = 1; i <= 6; i++) {
            int nx = x + i;
            if (nx <= 100) {
                if (map[nx] != 0) {
                    nx = map[nx];
                }
                solve(nx, moved + 1);
            }
        }
    }
}
