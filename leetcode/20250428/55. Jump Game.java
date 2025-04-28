/*
start:16:24
end:16:41
시간복잡도:O(N) 
공간복잡도:O(N)->O(1)
풀이: 깜짝놀랐다.. 이렇게 쉽고 간단한 풀이가있다니?(밑에 2번째 코드) 
나는 dp로 풀었지만.. 두번째풀이를 보면 목표지점을 줄여가며 풀고있다.
공간복잡도도 변수 1개만 둬서 푸는 진짜 참신한 풀이다! 결국 목표가 줄어들고 목표값이 0에 도달할수있는지 확인해주면 된다.

*/
class Solution {
    int[] dp=new int[10001];
    public boolean canJump(int[] nums) {
        for(int i=0;i<nums.length;i++)dp[i]=-1;
        return solve(nums,0) == 1;
    }
    int solve(int[] nums,int idx){
        if(idx>= nums.length-1)return 1;
        if(dp[idx] !=-1 )return dp[idx];
        for(int i=nums[idx];i>0;i--){
           dp[idx] = solve(nums,idx+i);
           if(dp[idx]==1)return 1;
        }
        return dp[idx] = 0;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int goal= nums.length-1;
        for(int i=nums.length-1; i>=0;i--){
            if(i+ nums[i]>= goal){goal = i;}
        }
        return goal == 0;
    }
}
