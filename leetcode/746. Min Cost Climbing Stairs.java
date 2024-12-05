/*
start: 16:24
end: 16:54
시간복잡도: O(n) - n은 계단의 개수
공간복잡도: O(n) - 메모이제이션을 위한 dp 배열 사용
풀이: dp를 이용해 각 계단에서의 최소 비용을 계산하는 top-down 방식
1. dp[i]: i번째 계단에서 시작할 때 도달하는데 필요한 최소 비용
2. 두 가지 시작점(0, 1)에서 시작하여 더 작은 비용 선택
3. 각 계단에서:
  - 현재 계단 비용 + min(한 계단 이동, 두 계단 이동)
  - 이미 계산된 값이면 dp에서 반환
4. 기저 조건: 계단 끝을 넘어가면 0 반환
*/
class Solution {
   Integer[] dp = new Integer[1001];// 래퍼클래스로 NULL이 초기값으로 들어가게 하자! 
   public int minCostClimbingStairs(int[] cost) {
       return Math.min(calculateCost(cost, 0), calculateCost(cost, 1));
   }
   
   private int calculateCost(int[] cost, int index) {
       // 기저 조건
       if(index >= cost.length) return 0;
       
       // 이미 계산된 값이면 반환
       if(dp[index] != null) return dp[index];
       
       // 현재 비용 + min(1계단, 2계단)
       return dp[index] = cost[index] + 
           Math.min(calculateCost(cost, index+1), 
                   calculateCost(cost, index+2));
   }
}
