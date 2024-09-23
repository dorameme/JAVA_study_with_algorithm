/*
start:16:30
end:17:11
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 재귀 + 완전탐색을 이용해서 구현했다! 처음엔 N*N의 풀이가 제일 먼저 떠올랐지만 생각해보니 한번만 쭉 스캔하면 되었다.
*/
class Solution {

    public int down(int idx,int[] nums){
        if(idx>=nums.length-1){
            return idx;}
        if(nums[idx]<=nums[idx+1])return idx;
        return down(idx+1,nums);
    }
    public int up(int idx,int[] nums){
        if(idx>=nums.length-1)return idx;
        if(nums[idx]>=nums[idx+1])return idx;
        return up(idx+1,nums);

    }
    public int solution(int[] nums) {
        int answer = 1;
        int start = 0;
        while(start<=nums.length-1){
            int moveUp= up(start,nums);
            int moveDown = down(moveUp,nums);
            if(moveUp==moveDown){
                moveUp+=1;
                start+=1;
                moveDown+=1;
            }
            answer= Math.max(answer, moveDown-start+1);
            start=moveDown;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
