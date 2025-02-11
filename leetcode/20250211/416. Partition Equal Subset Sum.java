/*
start: 8:00
end: 8:26
시간복잡도: O(n * sum/2) → n은 배열의 크기, sum은 배열의 총합. 각 요소에 대해 가능한 부분합을 갱신함.
공간복잡도: O(sum/2) → 1차원 배열(vis)을 사용하여 공간 최적화.
풀이:
1. 주어진 배열의 합(total)을 계산한다.
2. total이 홀수이면 두 부분으로 나눌 수 없으므로 false를 반환한다.
3. vis 배열을 선언하고, vis[0]을 true로 설정한다.
4. 각 숫자에 대해 뒤에서부터 total/2까지의 값을 갱신하며, 만들 수 있는 부분합을 표시한다.
5. vis[total/2]가 true이면 두 부분 집합이 같은 합을 가질 수 있으므로 true를 반환한다.
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i]; 
        }
        if(total%2==1)return false;
        boolean[] vis= new boolean[total+1];
        vis[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=total/2;j>=nums[i];j--){//한개씩밖에 못쓰니까 중복안되게 제일 큰수부터 시작
                if(j-nums[i]>=0 && vis[j-nums[i]]){
                    vis[j]=true;
                }
            }
        }
        return vis[total/2];
    }
}
