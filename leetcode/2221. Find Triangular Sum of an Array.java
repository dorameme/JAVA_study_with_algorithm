/*
start: 17:15
end: 17:37 
시간복잡도: O(n²) - n은 배열의 길이
공간복잡도: O(n) - dp 배열 사용
풀이: 파스칼의 삼각형 형태로 위로 올라가며 각 단계에서 인접한 두 수의 합의 일의 자리를 계산
1. 입력 배열을 dp 배열로 복사
2. 맨 아래 행부터 위로 올라가며:
  - 각 단계에서 인접한 두 수를 더하고 10으로 나눈 나머지 계산
  - dp[j] = (dp[j] + dp[j+1]) % 10
3. 마지막에 남는 하나의 수가 정답
*/
class Solution {
   public int triangularSum(int[] nums) {
       // dp 배열 초기화 및 입력 배열 복사
       int[] dp = new int[nums.length];
       System.arraycopy(nums, 0, dp, 0, nums.length);
       
       // 삼각형 형태로 위로 올라가며 계산
       for(int row = nums.length - 1; row > 0; row--) {
           for(int col = 0; col < row; col++) {
               dp[col] = (dp[col] + dp[col + 1]) % 10;
           }
       }
       
       return dp[0];
   }
}
