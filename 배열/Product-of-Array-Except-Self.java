2024-06-10
1. 완전탐색으로 풀기<-내가 푼 방식
2. left배열 right배열 만들어서 풀기 -> i번쨰면 left[i-1]*right[i+1];
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int mutiplyAll=1;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(zero==1)return answer;
                zero++;
            }
            else{
                mutiplyAll*=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
            answer[i]= mutiplyAll/nums[i];
            else{
                int[] helper = new int[nums.length];
                helper[i]= mutiplyAll;
                return helper;
            }            
        }
        return answer;
    }
}
