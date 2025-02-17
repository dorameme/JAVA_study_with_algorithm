/*
start:12:48
end:13:42
시간복잡도:O(N*N)
공간복잡도:O(N*N)
풀이: DP 로 쉽게 풀수있다.
1. 0부터 시작!
2.현재 nums에서 가져온값을 cur이라하면 
3. dp 가 -1 이 아닌 애들에 한해 dp[cur] = dp[cur], dp[x-cur]+1 이 된다!!
주의할거는 중복방지를 위해 뒤에서부터 탐색해야 한다는것 ~_~!!!!!!!! 그래서 target ~ nums 순으로 for문을 돌려준다
*/

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);  // 초기값 -1 (만들 수 없는 경우)
        dp[0] = 0;  // 합이 0일 때는 길이 0//!!!

        for (int num : nums) {
            for (int j = target; j >= num; j--) {  // 뒤에서부터 갱신 (중복 사용 방지)
                if (dp[j - num] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - num] + 1);
                }
            }
        }

        return dp[target];
    }
}
