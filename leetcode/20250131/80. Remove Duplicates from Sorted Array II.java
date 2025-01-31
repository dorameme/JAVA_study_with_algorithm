/*
start:14:30
end:15:18
시간복잡도: O(n)  // 배열을 한 번 순회하므로 선형 시간복잡도를 가짐.
공간복잡도: O(1)  // 추가적인 공간을 사용하지 않고 입력 배열을 그대로 수정.
풀이: 
- 배열을 순회하며 중복된 요소를 제거하고, 최대 두 번까지 허용.
- `before1`과 `before2`를 사용하여 현재 요소가 이전 두 요소와 동일한지 확인.
- 동일하지 않은 경우에만 결과 배열에 추가하고, `answer`를 증가.
- 결과적으로 중복이 제거된 배열의 길이를 반환.
근데 더 쉬운방법은 그냥 
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}
이렇게 풀면됨!! 어차피 오름차순이라 2개전 값보다 크면 중복이 2개이하이니 넣어주는 형식!!
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int answer=0;
        int idx=0;
        int before1=-10001;
        int before2=-10001;
        for(int i=0;i<nums.length;i++){
            if(before1== before2 && before1 == nums[i]){//같을때
                continue;
            }
            else{
                before1=before2;
                before2=nums[i];
                answer++;
                nums[idx++]= nums[i];
            }
        }
        return answer;
    }
}
