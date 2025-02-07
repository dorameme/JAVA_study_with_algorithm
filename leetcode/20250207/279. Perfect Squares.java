/*
start: 13:23
end: 13:39

시간 복잡도: O(N√N)
 - 외부 루프는 `O(N)`, 내부 루프에서 최대 `O(√N)`번 반복하여 최소 개수를 찾음.

공간 복잡도: O(N)
 - DP 배열 `dp[n]`을 사용하므로 O(N)의 추가 공간이 필요.

풀이:
1. `dp[i]`를 `i`를 만들기 위한 최소 제곱수 개수로 정의한다.
2. 초기값 설정: `dp[i] = i` (최악의 경우 `1^2`을 `i`번 더하는 경우).
3. `dp[i]`를 갱신할 때, `j^2`을 뺀 `dp[i - j^2] + 1`의 최소값을 찾는다.
4. 최종적으로 `dp[n]`을 반환한다.
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // 초기값 설정 (최악의 경우 1^2을 n번 더하는 경우)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        // 제곱수를 이용한 DP 갱신
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) { // j는 제곱수만 고려
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];   
    }
}
