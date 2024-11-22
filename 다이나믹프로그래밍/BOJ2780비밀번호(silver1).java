/*
 * start:16:37
 * end:16:54
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: DP문제풀때 항상 MOD로 잘 나눠주자..
 answer같은 경우도 한번 더할때마다 MOD로 나머지를 구해줘야한다.
static final int MOD = 1234567;
    static final int[][] NEXT = {
        {7},           // 0
        {2, 4},        // 1
        {1, 5, 3},     // 2
        {2, 6},        // 3
        {1, 5, 7},     // 4
        {2, 4, 6, 8},  // 5
        {3, 5, 9},     // 6
        {4, 8, 0},     // 7
        {5, 7, 9},     // 8
        {8, 6}         // 9
    };
그리고 인접한 번호를 이렇게 static final 로 정해두는게 좋다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int MOD = 1234567;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] answer = new long[100001];
        answer[1]=10;
        long[][] dp = new long[100001][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        int[][] next=new int[10][4];
        next[0]=new int[]{7,-1,-1,-1};
        next[1]=new int[]{2,4,-1,-1};
        next[2]=new int[]{1,5,3,-1};
        next[3]=new int[]{2,6,-1,-1};
        next[4]=new int[]{1,5,7,-1};
        next[5]=new int[]{2,4,6,8};
        next[6]=new int[]{3,5,9,-1};
        next[7]=new int[]{4,8,0,-1};
        next[8]=new int[]{5,7,9,-1};
        next[9]=new int[]{8,6,-1,-1};
        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int k=0;k<4;k++){
                   int cur= next[j][k];
                   if(cur==-1)continue;
                   dp[i][j]+= dp[i-1][cur];
                   dp[i][j]%=MOD;
                }
                answer[i]+=dp[i][j];
                answer[i]%=MOD;
            }
        }
        for(int i=0;i<N;i++)
        System.out.println(answer[Integer.parseInt(br.readLine())]);
    }

}
