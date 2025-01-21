/*
start:19:27
end:20:07
시간복잡도: O(n^2)
공간복잡도: O(n)
풀이:
- dp[i][0]는 i일에 주식을 샀을 때의 최대 이익을 저장.
- dp[i][1]는 i일에 주식을 팔았을 때의 최대 이익을 저장.
- 첫 번째 날에는 주식을 살 수밖에 없으므로 dp[0][0] = -prices[0]으로 초기화.
- 주식을 살 때는 이전에 주식을 팔았던 날에서 두 번째 날부터는 사는 이익을 갱신.
- 주식을 팔 때는 이전에 주식을 샀던 날에서 팔 때의 이익을 갱신.
- 주식을 팔 때마다 가능한 최대값을 answer에 저장.
하지만 이 풀이는 구리다. for 문 1개로 해결가능하기 때문. 밑에다 다시 풀어서 첨부하겠음
*/
class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int answer = 0;
        int[][] dp = new int[len][2]; // dp[i][0]는 i에 산거 dp[i][1]은 i에 판거
        dp[0][0] = -prices[0]; // 첫 번째 날에 주식을 샀으므로 가격을 음수로 설정
        for (int i = 1; i < len; i++) {
            dp[i][0] = -prices[i]; // i일에 주식을 사는 경우
            for (int j = 0; j < i; j++) {
                if (i - j - 2 >= 0) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] - prices[i]); // 사는 경우
                }
                dp[i][1] = Math.max(dp[i][1], prices[i] + dp[j][0]); // 파는 경우
            }
            answer = Math.max(answer, dp[i][1]); // 최대 이익 업데이트
        }
        return answer;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // Initialize the dp arrays for hold, sell, and cooldown states
        int hold = -prices[0]; // We bought on day 0
        int sell = 0;          // We haven't sold yet
        int cooldown = 0;      // Initially in cooldown state (i.e., no transaction)

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            hold = Math.max(hold, cooldown - prices[i]); // Max of holding from previous day or buying today after cooldown
            cooldown = Math.max(cooldown, sell); // Max of cooldown from previous day or selling today
            sell = Math.max(sell, prevHold + prices[i]); // Max of selling today or keeping the previous sell value
        }

        return Math.max(sell, cooldown); // Return the maximum profit, either selling or being in cooldown
    }
}

