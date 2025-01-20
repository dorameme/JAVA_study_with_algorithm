/*
start:9:58
end:10:11
시간복잡도:O(N)
공간복잡도:O(N)
풀이:dp[i]를 nums[i]로 끝나는 최대 연속 부분합으로 정의하고, 
dp[i] = nums[i] + max(dp[i-1], 0)로 갱신하며 최대값을 구한다.
*/
class Solution {

    public int maxSubArray(int[] nums) {
       int len = nums.length;  
       int[] dp= new int[len];
       dp[0]= nums[0];
       int answer= dp[0];
       for(int i=1;i<len;i++){
            dp[i]= nums[i]+(dp[i-1]>0? dp[i-1]:0); // 이부분 괄호 잘 쳐줘야함!!
        
            answer = Math.max(answer ,dp[i]);
       }
       return answer;
    }
}
