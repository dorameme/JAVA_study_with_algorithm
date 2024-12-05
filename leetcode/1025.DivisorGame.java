/*
start: 13:56
end: 14:13
시간복잡도: O(N*sqrt(N))
공간복잡도: O(N)
풀이: 중요한건 해당 Turn에서 이길 수 있는 경우가 하나라도 있으면 무조건 이긴다는 것이다. -> 그리고 턴은 재귀적으로 관리해주면 됨!
1. n이 1이면 더 이상 움직일 수 없으므로 패배
2. dp[n]이 이미 계산되어 있다면 그 값을 반환
3. 1부터 sqrt(n)까지 순회하며 약수를 찾음:
  - n을 i로 나눈 나머지가 0이면 약수
  - n-i 또는 n-n/i 만큼을 다음 턴에 넘김
  - 다음 턴에서 상대가 패배하는 경우가 있다면 현재 턴은 승리
4. 어떤 경우도 승리로 이어지지 않으면 패배
*/
class Solution {
   Boolean answer;
   Boolean[] dp = new Boolean[1001];
   
   public boolean divisorGame(int n) {
       if (n == 1)
           return false;
           
       if (dp[n] != null)
           return dp[n];
           
       for (int i = 1; i * i <= n; i++) {
           if (n % i == 0) {
               if (!divisorGame(n - i)) {
                   return dp[n] = true;
               }
               if (i != 1 && !divisorGame(n - n/i)) {
                   return dp[n] = true;
               }
           }
       }
       return dp[n] = false;
   }
}
