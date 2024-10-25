/*
 * start:15:00
 * end:15:33
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 Key Implementation Details:
Implements iterative DP rather than recursive approach
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, answer = 987654321;
    static int[] P;
    static int[] dp;///idx 개 사는 데 필요한 최솟값

    public static void payment() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= N; i++) {
            dp[i] = P[i-1];
        }
        payment();
        System.out.println(dp[N]);
    }
}
