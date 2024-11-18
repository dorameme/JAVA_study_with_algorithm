/*
 * start:11:55
 * end:12:15
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: dp를 채울때 그냥 함수하나에서 다 담당하는게 나을 것같다..  initDP(); 하나만 호출해도 되게!!
 private static void initDP() {
        // 1자리 수에 대한 초기화
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        
        // 2자리 수부터 계산
        for (int digits = 2; digits <= 65; digits++) {
            for (int lastNum = 0; lastNum <= 9; lastNum++) {
                for (int prevNum = 0; prevNum <= lastNum; prevNum++) {
                    dp[digits][lastNum] += dp[digits-1][prevNum];
                }
            }
        }
    }
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static long[][] dp =new long[66][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<=9;i++){
            dp[1][i]=1;//size, startNum
        }
      for(int i=2;i<=65;i++){
          asc(i,0);
      }
        for (int i = 0; i < N; i++) {
            System.out.println(dp[(Integer.parseInt(br.readLine()))+1][9]);
        }
    }

    public static void asc(int n,int startNum) {

        for (int i = 0; i < 10; i++) {
            for(int j=0;j<=i;j++){
                dp[n][i]+=dp[n-1][j];
            }
        }
    }
}

