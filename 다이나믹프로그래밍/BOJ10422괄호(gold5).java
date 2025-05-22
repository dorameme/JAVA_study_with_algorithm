/*
start: 14:05  
end: 14:19  
시간복잡도: O(N^2)  
공간복잡도: O(N^2)  
풀이:-> O(2^N)이라고 착각할수있는데 메모이제이션때문에 그렇게 안됨 ㅋㅋ
*/
package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static long[][] dp = new long[5001][5001];
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 5001; i++) {
            Arrays.fill(dp[i], -1);
        }
        while (N-- > 0) {
            int l = Integer.parseInt(br.readLine());
            if (l % 2 == 1) {
                System.out.println(0);
                continue;
            }
            System.out.println(solve(l, 0));
        }
    }

    static long solve(int cnt, int closed) {//
        if (cnt == 0) {
            if (closed == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[cnt][closed] != -1) {
            return dp[cnt][closed];
        }
        long ret = 0;
        if(closed>0)
        ret += solve(cnt - 1, closed - 1);
        ret%=1000000007;
        ret += solve(cnt - 1, closed + 1);
        ret%=1000000007;
        return dp[cnt][closed] = ret;
    }
}
