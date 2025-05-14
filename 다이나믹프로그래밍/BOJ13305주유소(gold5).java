
/*
start: 21:50  
end: 22:43  
시간복잡도: O(N * K) <- N: 물건 개수, K: 최대 무게  
공간복잡도: O(N * K) <- dp 테이블 크기 (100 x 100000)  

풀이:  
원칙적으로 메모이제이션에서 중요한 건?
"문제의 상태(state)"를 대표하는 값들만 dp 인자 또는 키로 써야 한다.
즉, 현재 상태에서 미래 결정에 영향을 주는 값만 저장하면 충분

- DP (Top-Down 방식, 메모이제이션 적용)  
- 각 보석을 선택할지 말지를 결정하며, 최대 가치 합을 구하는 0-1 Knapsack 문제  
- dp[idx][weight]는 idx번째 보석부터 남은 무게가 weight일 때 얻을 수 있는 최대 가치  
- 보석을 선택하는 경우와 선택하지 않는 경우 중 최댓값을 선택  
- 재귀로 탐색하면서 이미 계산한 경우는 dp 테이블을 통해 중복 계산 방지
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main {

    static int[][] dp = new int[101][100001];
    static int[][] jewel = new int[101][2];
    static HashMap<Integer, Integer> m = new HashMap<>();
    static int total = 0;
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        K = s[1];
        for (int i = 1; i <= N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            jewel[i][0] = arr[0];
            jewel[i][1] = arr[1];

        }
        for (int i = 1; i <= N; i++) {
            for(int w=0;w<=K;w++){
                if(w<jewel[i][0]){
                    dp[i][w]= dp[i-1][w];
                }else{
                    dp[i][w]=Math.max( dp[i-1][w], dp[i-1][w-jewel[i][0]]+jewel[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
//다른풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main {
    static int[][] dp = new int[101][100001];
    static int[][] jewel = new int[101][2];
    static HashMap<Integer, Integer> m = new HashMap<>();
    static int total = 0;
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        K = s[1];
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            jewel[i][0] = arr[0];
            jewel[i][1] = arr[1];
        }
        System.out.println(solve(0,  K));
    }

    static int solve(int idx,  int weight) {
        if (idx == N) {
            return total;
        }
        if(dp[idx][weight]!=0)return dp[idx][weight];
        if (weight - jewel[idx][0] >= 0) {
            dp[idx][weight]= solve(idx + 1, weight - jewel[idx][0]) +    jewel[idx][1]  ;
        }
        return dp[idx][weight]= Math.max( dp[idx][weight], solve(idx + 1,  weight));
    }
}
