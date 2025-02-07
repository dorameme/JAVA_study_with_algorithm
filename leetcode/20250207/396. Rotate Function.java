/*
start: 16:20
end: 16:29

시간복잡도: O(N)
 - F(0)를 계산하는 데 O(N), 이후 각 회전에 대해 O(1) 연산을 수행하므로 전체 O(N).

공간복잡도: O(1)
 - 추가 배열 없이 정수 변수만 사용하므로 O(1).

풀이:
1. F(0)를 계산한다. (F(0) = nums[i] * i)
2. 전체 배열 합(sum)을 구한다.
3. 점화식 `F(k) = F(k-1) + sum - n * nums[n-k]`을 사용하여 O(N)으로 최대값을 찾는다.
*/
class Solution {
    public int maxRotateFunction(int[] nums) {
        int answer=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            answer += nums[i]*i;
            sum += nums[i];
        }   
        int helper=answer;
        for(int i=0;i<nums.length;i++){
            helper= helper+sum-nums[nums.length-1-i]*(nums.length);
            answer = Math.max(helper,answer);
        }
        return answer;
    }
}
