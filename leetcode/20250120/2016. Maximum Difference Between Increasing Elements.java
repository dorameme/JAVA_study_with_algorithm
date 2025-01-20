/*
start:10:20
end:10:45
시간복잡도:(N)
공간복잡도:O(1)
풀이: 상세한 조건까지도 잘 맞춰야 한다.
*/
class Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int small= nums[0];
        int big= nums[0];
        int answer=nums[1]-nums[0];
        for(int i=1;i<len;i++){
            answer= Math.max(answer , nums[i]-small);
            if(nums[i]<small)small = nums[i];
        }
        return answer<=0? -1:answer;
    }
}
