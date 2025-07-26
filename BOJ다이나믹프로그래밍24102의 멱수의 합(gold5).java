/*
start:10:58
end:11:03
시간복잡도:O(nlogn)
공간복잡도:O(n)
풀이: 동전1 문제보다 살짝 더 어려운데 난이도는 1 더 낮다.
-> 2의 거듭제곱(1, 2, 4, 8, ...)을 동전처럼 보고, 해당 수들로 n을 만드는 경우의 수를 구하는 문제이다.
   전형적인 1차원 DP 방식으로, dp[i]는 i를 만드는 경우의 수를 의미하며, 이전 값을 누적해서 채워간다.
*/
package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {


    static int ans;

    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] dp = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 1; i <= n; i*=2) {
            arr.add(i);
        }
        dp[0]=1;
        for(int two:arr){
            for(int i=0;i<=n;i++){
                if(i>=two)
                dp[i]+= dp[i-two];
                dp[i]%= 1_000_000_000;
            }
        }

        System.out.println(dp[n]);
    }

}
