package 배열;
/*
 * start:10:27
 * end:10:33
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:간단한 dp문제였다.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] dp=new long[70];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<69;i++){
            dp[i]= dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
        }
        for(int i=0;i<N;i++){
            int  num= Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
