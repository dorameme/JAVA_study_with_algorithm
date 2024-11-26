/*
 * start:17:30
 * end:18:14
 * 시간복잡도:O(N * M * K) (N: 동전 수, M: 금액, K: 각 동전으로 가능한 최대 개수)
 * 공간복잡도: O(N * M * K) (N: 동전 수, M: 금액, K: 각 동전으로 가능한 최대 개수)
 * 풀이:이 코드에서는 DP가 불필요함..
 Unbounded Knapsack의 특징(동전 무제한 사용)을 가지고 있지만
순차적으로 한 방향으로만 진행되어 중복 계산이 발생하지 않는 특별한 케이스
따라서 일반적인 Unbounded Knapsack 문제와 달리 DP 없이도 해결 가능하다.

상태 변화 패턴
idx가 항상 감소하면서 재귀 호출됨 (N-1 → N-2 → ... → 0)
같은 상태를 두 번 방문할 일이 없음
money가 달라도 idx가 계속 작아지기만 함
따라서 밑의 dp코드가 없어도 정상작동한다. 
static public int solve(int money, int idx) {
    int result = 0;
    if (money == 0) return 1;
    if (idx == 0) return money % arr[idx] == 0 ? 1 : 0;
    
    for (int i = 0; money - i * arr[idx] >= 0; i++) {
        result += solve(money - arr[idx] * i, idx - 1);
    }
    return result;
}
static public int solve(int money, int idx) {
    if (money == 0) return 1;
    if (idx == 0) return money % arr[idx] == 0 ? 1 : 0;
    if (dp[money] != 0) return dp[money];  // 중복 계산 방지
    
    int result = 0;
    for (int i = 0; money - i * arr[idx] >= 0; i++) {
        result += solve(money - arr[idx] * i, idx - 1);
    }
    return dp[money] = result;
}
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] dp;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(stk.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            dp = new int[money + 1];
            int answer= solve(money, N - 1);
            System.out.println(answer);
        }
    }

    static public int solve(int money, int idx) {
       int result= 0;
        if (money == 0) {
            return 1;
        }
        if (idx == 0) {
            return money % arr[idx] == 0 ? 1 : 0;
        }
        for (int i = 0; money - i * arr[idx] >= 0; i++) {
           result += solve(money - arr[idx] * i, idx - 1);
        }
        return result;
    }
}
