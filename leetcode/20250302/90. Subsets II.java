/*
start: 12:46
end: 13:33
시간복잡도: O(2^n)
공간복잡도: O(n)
풀이:
이 문제는 중복된 부분집합을 구하는 문제로, 먼저 배열을 정렬한 후 재귀적인 방법으로 모든 부분집합을 생성하고, 중복된 부분집합을 피하기 위해 HashSet을 사용한다.
set.contains(helper)로 이미 부분집합이 중복되는지 확인하고, 중복되지 않는 부분집합만 set에 추가하여 결과를 반환한다.
*/
class Solution {
    HashSet<List<Integer>> set= new HashSet<>();
    List<Integer> helper =new ArrayList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(0,nums);
        return new ArrayList<>(set);
    }
    void subsets(int idx,int[] nums) {  
         if(idx==nums.length){
            set.add(new ArrayList<Integer>(helper));
            return ;
        }
        if(set.contains(helper))return ;

        helper.add(nums[idx]);
        subsets(idx+1,nums);
        helper.removeLast();
        subsets(idx+1,nums);        
        return ;
    }
}
