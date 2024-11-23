/*
 * start:13:49
 * end:14:03
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 합이 0으로 끝나는 경우 2로 끝나는경우 3으로 끝나는 경우를 구해준다.
 근데 사실 모든 dp[i] [0]~[2] 다같으니까 dp안풀어도 되긴함 ㅋㅋ

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[33334][3];
        dp[0][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] +dp[i-1][0])%MOD;
            dp[i][1] =  (dp[i - 1][1] + dp[i - 1][2] +dp[i-1][0])%MOD;
            dp[i][2] =  (dp[i - 1][1] + dp[i - 1][2] +dp[i-1][0])%MOD;
        }
        System.out.println(dp[N][0]);
}
}
