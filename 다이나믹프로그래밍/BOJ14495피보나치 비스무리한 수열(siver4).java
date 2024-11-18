
/*
 * start:12:15
 * enㅇ:12:19
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 변형된 피보나치문제.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static long[] dp = new long[200];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibo();
        System.out.println(dp[N]);
    }

    static void fibo() {
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 3; i <= 116; i++) {
            dp[i] = dp[i - 3] + dp[i - 1];
        }
    }
}
