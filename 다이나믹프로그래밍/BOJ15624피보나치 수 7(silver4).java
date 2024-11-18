/*
 * start:10:33
 * enㅇ:10:44
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:피보나치인데 내가 간과한 점이 몇게 있어서 런타임 에러 (ArrayIndexOutOfBounds) 가 났다.
이유는 일단 배열을 변수로 할당해서다..
long[] dp= new long[N*2]; 라고 했는데 그러면 0이 들어올때 에러가 난다.. 주의하자 
그리고 항상 테스트케이스의 말단값으로 확인하는 습관이 필요할 것 같다.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+10];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        System.out.println(dp[N]);
    }
}
