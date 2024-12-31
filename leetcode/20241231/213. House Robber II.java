/*
start:19:30
end:19:38

시간복잡도: O(N) - 주어진 배열을 한 번 순회하므로 선형 시간 복잡도를 가진다.
공간복잡도: O(N) - 동적 프로그래밍 배열(dp)을 사용하여 추가적인 메모리를 소비한다.

풀이:
이 문제는 원형 배열(첫 번째와 마지막 원소가 연결됨)에서 인접한 집을 터는 것이 불가능할 때, 최대 금액을 훔치는 문제이다.

1. 원형 배열 특성을 고려하여 두 가지 경우로 나눈다.
   - 첫 번째 집을 선택하고 마지막 집은 선택하지 않는다.
   - 첫 번째 집을 선택하지 않고 마지막 집을 선택한다.

2. 두 가지 경우 각각에 대해 1차원 동적 프로그래밍(dp) 배열을 생성하여 계산한다.
3. 두 경우의 최댓값을 구해 정답을 도출한다.
*/
//클린코드 함수 하나를 만들어서 푸는경우
class Solution {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0]; // 집이 하나만 있는 경우 직접 반환

        // 첫 번째 집을 포함한 경우 계산
        int includeFirst = robLinear(nums, 0, len - 2);
        // 첫 번째 집을 제외한 경우 계산
        int excludeFirst = robLinear(nums, 1, len - 1);

        // 두 경우 중 최댓값 반환
        return Math.max(includeFirst, excludeFirst);
    }

    // 선형으로 계산하는 도우미 함수
    private int robLinear(int[] nums, int start, int end) {
        int prevTwo = 0, prevOne = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}


//내 풀이 그냥 함수없이 dp 로 푸는경우
class Solution {
  
    int[][] dp;
    int answer = 0;
    int len;

    public int rob(int[] nums) {
        
        len = nums.length;
        if(len==1)return nums[0];
        dp = new int[len][2];
        for(int i=0;i<len;i++){
            dp[i][0]=dp[i][1]=-1;
        }
        dp[0][0] = 0;//선택 x
        dp[1][0] = nums[1];
        dp[0][1] = nums[0];
        dp[1][1] = nums[0];
        for (int i = 2; i < len - 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
            answer = Math.max(dp[i][0],dp[i][1]);
        }
        if(len>=3)
        dp[len-1][0] = Math.max(dp[len - 3][0] + nums[len-1], dp[len - 2][0]);
        dp[len-1][1]= dp[len-2][1];
        answer= Math.max(dp[len-1][0],dp[len-1][1]);
        return answer;
    }
}
