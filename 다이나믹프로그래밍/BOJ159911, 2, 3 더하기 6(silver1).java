/*
 * start:16:01
 * end:16:27
 * 시간복잡도:O(N)
 * 공간복잡도: O(N)
 * 풀이: 처음엔 가운데에 1,2,3을 각각 배치하는 풀이를 풀려고 했는데...
 그냥 가상에다가 각각에 1,2,3중하나를 골라 양끝에 두는경우로 푸는게 더 쉽다..
 왜냐면 처음풀이는 홀짝도 고려해줘야하거든..
 static final int MOD = 1_000_000_009;로 매직넘버를 두고풀었다..
 아니 나는 나누기라고 썼는데 MOD도 괜춘한듯.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int 나누기 = 1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];
        dp[0]=1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5]= 3;
        dp[6]=6;
        for (int i = 6; i <= 100000; i++) {
            dp[i]=((dp[i-2]+dp[i-4])%나누기+dp[i-6])%나누기;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
