/*
 * start:12:36
 * end:12:44
 * 시간복잡도:O(N^M)
 * 공간복잡도:O(N^M)
 * 풀이: 원래 이런 부류의 문제 많아서. 그냥 엄청 쉽게 풀었다. 
 2차원 누적 합 문제였는데
2차원 배열에서 (1,1)부터 특정 좌표(i,j)까지의 부분 직사각형 영역에 있는 모든 원소들의 합을 미리 계산해두는 방식이다.
dp[i][j] = (1,1)부터 (i,j)까지의 직사각형 영역의 합
dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + map[i][j]
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static long[][] map = new long[1025][1025];
    static long[][] dp = new long[1025][1025];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] -dp[i-1][j-1] + map[i][j];
            }
        }
        stk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            System.out.println(dp[x2][y2]+dp[x-1][y-1] -dp[x2][y-1]-dp[x-1][y2]);
        }
    }
}
