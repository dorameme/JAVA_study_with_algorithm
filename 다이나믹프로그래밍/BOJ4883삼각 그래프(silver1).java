/*
 * start:13:00
 * end:13:15
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 문제의 의도와 조건을정확히 파악하는게 중요한 문제였다!!
첫줄과 그다음줄을 먼저 구해주고 그이후에 for문을 도는것이 포인트!
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int cnt = 0;
        while (true) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            if (N == 0) {
                return;
            }
            cnt++;
            int[][] map = new int[N][3];
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            long[][] dp = new long[N][3];
            dp[0][0] = map[0][0];
            dp[0][1] = map[0][1];
            dp[0][2] = map[0][1] + map[0][2];
            dp[1][0] = dp[0][1] + map[1][0];
            dp[1][1] = Math.min(dp[1][0],
                Math.min(dp[0][1], dp[0][2]))
                + map[1][1];
            dp[1][2] = Math.min(dp[1][1],
                Math.min(dp[0][1], dp[0][2]))
                + map[1][2];

            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][0])
                    + map[i][0];
                dp[i][1] = Math.min(dp[i][0],
                    Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])))
                    + map[i][1];
                dp[i][2] = Math.min(dp[i][1],
                    Math.min(dp[i - 1][1], dp[i - 1][2]))
                    + map[i][2];
            }
            System.out.println(cnt + ". " + dp[N - 1][1]);
        }
    }
}
