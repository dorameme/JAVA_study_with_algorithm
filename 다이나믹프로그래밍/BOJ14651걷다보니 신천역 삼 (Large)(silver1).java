/*
 * start:13:49
 * end:14:03
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 합이 0으로 끝나는 경우 2로 끝나는경우 3으로 끝나는 경우를 구해준다.
 근데 사실 모든 dp[i] [0]~[2] 다같으니까 dp안풀어도 되긴함 ㅋㅋ 근데 주의할게 MOD로 꼭 답을 나눠줘야함 그거안해서 처음에 틀림 --

 * */
package  배열;/*
 * start:21:16
 * end:
 * 시간복잡도:
 * 공간복잡도:
 * 풀이:

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

class Main {

    static final int MOD=1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println(0);return;}
        long answer=1;
        for(int i=2;i<N;i++){
            answer*=3;
            answer%=MOD;
        }
        System.out.println(answer*2%MOD);///이부분 중요!!
    }
}

//dp 풀이
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
