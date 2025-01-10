/*
start: 답안참고
end: 답안참고
시간복잡도: O(N^2) 
    - DP 테이블(dp[startIdx][lastIdx])을 채우는 데 필요한 모든 상태를 탐색한다.
    - 각각의 상태에서 최대 두 번의 재귀 호출을 수행하며, dp 배열의 크기는 N x N이다.
    
공간복잡도: O(N^2)
    - DP 배열이 N x N의 공간을 차지한다.
    - 재귀 호출의 스택 공간 복잡도는 O(N)이다. 하지만, DP 배열이 더 지배적이다.
    
풀이: 어려워서 답안을 참고했다. DP로는 왼쪽과 오른쪽 포인터를 이용해서 풀었다.
    1. startIdx와 lastIdx를 기준으로 두 플레이어가 점수를 최대화하려고 하는 게임에서 승리자를 예측한다.
    2. 플레이어는 배열의 양끝에서 하나를 선택하며, 그 후 상대 플레이어는 남은 배열로 같은 선택을 한다.
    3. 점수 차이가 0 이상이라면 첫 번째 플레이어가 승리할 수 있다.
    4. DP 배열 dp[startIdx][lastIdx]는 startIdx부터 lastIdx까지의 배열에서 첫 번째 플레이어가 얻을 수 있는 최대 점수 차이를 저장한다.
*/
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        return predictTheWinner(nums,0,nums.length-1,dp) >=0 ;
    }

    public int predictTheWinner(int[] nums, int startIdx, int lastIdx, int[][] dp) {
        // Base case: If there is only one element, the player picks it.
        if(startIdx==lastIdx)return nums[startIdx];
        // If the result for this state is already computed, return it
        if(dp[startIdx][lastIdx]!=0)return dp[startIdx][lastIdx];
        // Recursively calculate the result for both choices: pick start or pick end
        int resultFirst= nums[startIdx]- predictTheWinner(nums,startIdx+1,lastIdx,dp);
        int resultEnd= nums[lastIdx] -  predictTheWinner(nums,startIdx,lastIdx-1,dp);
        // Store the result in the dp array for the current state
        return dp[startIdx][lastIdx] = Math.max(resultFirst,resultEnd);
    }
}
