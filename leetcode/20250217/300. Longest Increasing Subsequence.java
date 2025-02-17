/*
start:13:42
end:14:06
시간복잡도:O(N*N)
공간복잡도:O(N*N)
풀이:이걸 이진탐색으로 풀면 휠씬 빨라진다! 코드는 아래 첨부 
*/
//개선된 이진탐색코드 

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                idx = -idx - 1; //  해당 값이 리스트에 없으며, 들어가야 할 위치를 음수 형태로 반환한다.
            }
            if (idx < lis.size()) {
                lis.set(idx, num); // 기존 위치 업데이트
            } else {
                lis.add(num); // 새로운 값 추가
            }
        }

        return lis.size();
    }
}
//내 O(N^2) 코드
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp= new int[20001];//인덱스보다 작거나 같은것들..
        int answer=0;
        for(int i=0;i<nums.length;i++){
            for(int j=nums[i]-1+10000;j>=0;j--){
                dp[nums[i]+10000]= Math.max(dp[nums[i]+10000], dp[j]+1);
            }
            if(nums[i]+10000==0)dp[0]=1;
            answer = Math.max(answer, dp[nums[i]+10000]);
        }return answer;
    }
}
