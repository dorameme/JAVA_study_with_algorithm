/*
start:11:23
end:11:47
시간복잡도:O(N^2 * M^2)
공간복잡도:O(NM)
풀이: 항상 초기값 설정에 주의하자!! 음수만 나올수도있으므로 Integer.MIN_VALUE를 써줘야한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);

            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int x = i ; x <= N; x++) {
                    for (int y = j ; y <= M; y++) {
                        max = Math.max(max, dp[x][y]-dp[i-1][y] -dp[x][j-1] +dp[i-1][j-1]);
                    }
                }
            }

    }
        System.out.println(max);
}
}
