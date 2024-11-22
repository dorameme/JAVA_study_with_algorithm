/*
 * start:17:10
 * end:17:37
 * 시간복잡도:O(N^2)
 * 공간복잡도:O(N^2)
 * 풀이:3중 포문으로 해결가능한 dp문제였다.
풀이하자면 N 을 M개의 수로 나타내는법을 찾는것!
N을 1 개 2개 3개 ..하나씩 쪼개가며 더해줘야한다.
근데 또 시작하는 숫자가 1,2,3 중하나라는 것을 이용해 풀어주었다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][1001];
//        long[] answer = new long[1001];
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for (int i = 4; i <= 1000; i++) {//나타내고자 하는 수

            for (int j = 1; j <= i; j++) {//i를 j개의 수로 나타내되
                for (int k = 1; k <= 3; k++) {//j개의 수가 k로 시작하는 경우
                    dp[i][j] += dp[i - k][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            System.out.println(dp[Integer.parseInt(stk.nextToken())][Integer.parseInt(
                stk.nextToken())]);
        }
    }
}
