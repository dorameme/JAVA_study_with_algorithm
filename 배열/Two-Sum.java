공부한 날짜 2024-05-23

1. 해쉬맵으로 풀기
    point: 나는 배열을 미리 선언한뒤 답을 넣어줬는데 그럴 필요없이
    return new int[]{~,~}; 이런식으로 리턴하는게 더 좋은 것 같다.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer= new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                answer[0] = i;
                answer[1] = map.get(target-nums[i]);
                return answer;
            }
            map.put(nums[i],i);
        }
        return answer;
    }
}