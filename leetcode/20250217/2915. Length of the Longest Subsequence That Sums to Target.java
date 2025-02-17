/*
start:12:48
end:13:42
시간복잡도:O(N*N)
공간복잡도:O(N*N)
풀이: DP 로 쉽게 풀수있다.
1. 0부터 시작!
2.현재 nums에서 가져온값을 cur이라하면 
3. dp 가 -1 이 아닌 애들에 한해 dp[cur] = dp[cur], dp[x-cur]+1 이 된다!!
주의할거는 중복방지를 위해 뒤에서부터 탐색해야 한다는것 ~_~!!!!!!!! 그래서 target ~ nums 순으로 for문을 돌려준다.
배낭문제인데 배낭문제는 다음과 같은 특징이 있다.
배낭 문제(Knapsack Problem)의 특징
✅ 1. 선택 문제 (선택하거나 선택하지 않거나)
주어진 요소(물건, 숫자 등) 중 일부를 선택하여 목표를 달성해야 한다.
예: "어떤 숫자들을 선택해서 target을 만들 수 있는가?"

✅ 2. 최대/최소 최적화 문제

"가장 큰 값" 또는 "가장 작은 값"을 찾아야 한다.
예: "합이 target이 되는 가장 긴 부분 수열의 길이?" (최대 길이 찾기)

✅ 3. 중복 선택이 제한됨 (0/1 Knapsack 구조)
각 숫자(또는 아이템)를 한 번만 선택 가능하다.
예: nums = [1, 2, 3]에서 2를 두 번 사용할 수 없는 경우

✅ 4. 부분 문제(subproblems)로 나누어 해결 가능
예를 들어, dp[i]를 "합이 i가 되는 경우의 최대 길이"로 정의하면,
dp[i]는 이전 상태 dp[i - num]을 기반으로 결정됨 → 배낭 문제의 점화식과 유사!
"현재 숫자를 추가했을 때의 최적해를 구하는 방식" → 배낭 문제 접근법과 동일
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
