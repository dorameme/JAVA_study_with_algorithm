/*
 * start:11:17
 * end:12:38
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:to solve the knapsack problem with a 1D array, use dp[j] to store the maximum value achievable with cost j. T
 raverse costs backward for each item to prevent double-counting, ensuring each item is only used once. 
 Update dp[j] by comparing the current and previous state (dp[j - cost] + value).
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, M, answer;
    static int[] m;
    static int[] c;
    static int[] dp ;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        M = s[1];
        m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum=Arrays.stream(c).sum();
        dp= new int[sum+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;

        for(int i=0;i<N;i++){
            for(int j=sum;j>=c[i];j--){
                if(dp[j-c[i]]!=Integer.MIN_VALUE){
                    dp[j]= Math.max(dp[j],dp[j-c[i]]+m[i]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int j=0;j<=sum;j++){
            if(dp[j]>=M)
            answer= Math.min(answer,j);
        }
        System.out.println(answer);
    }
}
