2024-06-10
1. 정렬해서 비교
point: 
컬렉션을 정렬할 때 Collections.sort(),기본형 배열을 정렬 Arrays.sort()
Collections.sort()는 내부적으로 List를 객체의 배열로 변환하고 Arrays. sort()를 호출하여 정렬한다.
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer =0;
        for (int i = 0; i < nums.length / 2; i++) {
            answer += nums[i*2];
        }
        return answer;
    }
}
