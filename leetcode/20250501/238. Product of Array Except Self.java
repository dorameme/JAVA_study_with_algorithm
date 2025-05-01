/*
start:11:00
end:11:24
시간복잡도:O(N)
공간복잡도:O(N) -> O(1)
풀이:다시푼문제 나는 O(N)에풀었지만..포인트는 공간복잡도를 o(1)로 두고푸는것이다. 
이문제 나는 front ,back 을 먼저구하고 곱해주는 형식으로했는데.... 생각해보니
그냥 배열1개로도 풀수있다!!.. -_-
그리고 이러면 왜이게 공간이 O(1)냐고 물어볼수있는데 (내가그랬다.)
~문제에서 말하는 공간복잡도 O(1)의 의미~
LeetCode 문제 238 - Product of Array Except Self의 설명을 보면 이렇게 적혀 있다:
The output array does not count as extra space for space complexity analysis.
"output 배열은 공간 복잡도 계산에서 제외한다."
*/

//이건 개선된 풀이 아래가 내풀이
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
         int[] answer = new int[n];

        // 1. 왼쪽 곱 누적값 저장
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2. 오른쪽 곱 누적값을 answer에 곱해주기
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }
}


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. 왼쪽 곱 누적값 저장
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2. 오른쪽 곱 누적값을 answer에 곱해주기
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }
}
