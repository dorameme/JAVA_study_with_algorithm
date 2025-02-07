/*
start: 13:39
end: 14:35
시간복잡도: O(N)
공간복잡도: O(N)
풀이:
1. `dp[i]`를 i번째 Ugly Number로 정의하고, 첫 번째 수는 항상 `1`로 설정한다.
2. 2, 3, 5의 배수를 추적하는 `p2, p3, p5` 포인터를 활용한다.
3. `dp[i]`는 `dp[p2] * 2`, `dp[p3] * 3`, `dp[p5] * 5` 중 **최솟값**으로 갱신된다.
4. 중복 방지를 위해, 최소값에 해당하는 포인터를 모두 증가시킨다.
5. `dp[n-1]`을 반환한다.
*/

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n]; // DP 배열 크기 수정 (n+1 → n)
        dp[0] = 1; // 첫 번째 Ugly Number는 1

        int p2 = 0, p3 = 0, p5 = 0; // 2, 3, 5의 배수를 추적하는 포인터

        for (int i = 1; i < n; i++) { // 반복 범위 수정 (i <= n → i < n)
            // 최소값을 선택하여 Ugly Number 추가
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));

            // 중복 방지: 사용된 포인터는 모두 증가
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1]; // n번째 Ugly Number 반환
    }
}
