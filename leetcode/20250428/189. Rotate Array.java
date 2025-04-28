/*
start:11:42
end:12:12
시간복잡도:O(N)
공간복잡도:O(1)
풀이: 조건은 공간복잡도 1안에 푸는것.. 나는 많이 헤멨다
풀이는 우선 다 뒤집은뒤, k값이하, k값 이후로 2번 더 뒤집어주면 답이나온다!
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
