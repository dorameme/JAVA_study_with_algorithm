/*
start:13:45
end:14:05
시간복잡도:O(N^2)->O(NlgN)
공간복잡도:O(N)->O(1)
풀이: 슬라이딩윈도우(투포인터 이용)으로 풀수있다. 근데 투포인터로 쓸려면 우선 r을 하나씩 증가시키고
그중 최소길이가되는 l을 찾아야한다!
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            for (int i =nums.length-1;i>=j; i--) {
                if(dp[i]<target)break;
                if (dp[i] - dp[i - j] + nums[i - j] >= target) {
                    return j +1;
                }
            }
        }
        return 0;
    }
}//밑에가 개선된 풀이!
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        for(right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];

            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
