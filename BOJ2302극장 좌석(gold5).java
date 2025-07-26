/*
start:11:05
end:11:25
시간복잡도:O(N) 한 번의 순회로 해결 가능하다.
공간복잡도:O(N) 배열과 VIP 좌석을 저장하는 배열 각각 N의 크기를 필요
풀이: 이 문제는 다이나믹 프로그래밍을 사용하여 해결할 수 있다.
VIP 좌석을 제외한 일반 좌석들에 대해, 연속된 일반 좌석이 있을 경우 해당 좌석들끼리 자리를 바꿀 수 있는 경우의 수를 계산한다.
DP[i]는 i번째 좌석까지 고려했을 때 가능한 경우의 수를 나타내며, 점화식은 다음과 같다:

현재 좌석이 VIP가 아니고 이전 좌석도 VIP가 아닌 경우: DP[i] = DP[i-1] + DP[i-2] (앉는 경우 + 자리 바꾸는 경우)

그 외의 경우: DP[i] = DP[i-1] (현재 좌석에 그대로 앉는 경우만 가능)
초기값으로 DP[0]과 DP[1]은 1로 설정한다.
*/
package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt( bf.readLine());
        int m = Integer.parseInt( bf.readLine());
        int[] dp = new int[n + 2];
        boolean[] vip = new boolean[n+2];
        for (int i = 0; i < m; i++) {
            vip[Integer.parseInt(bf.readLine())] = true;
        }
        dp[1]=1;
        dp[0]=1;//앞이랑 자리바꾸는 경우 필요..
        for(int i=2;i<=n;i++){
            if(!vip[i] && !vip[i-1])
            dp[i] += dp[i-2];//앞이랑 자리바꿈
            dp[i] += dp[i-1];//현재좌석에 앉음.
        }
        System.out.println(dp[n]);
    }
}
