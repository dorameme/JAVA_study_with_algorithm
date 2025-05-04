/*
start:15:25
end:15:30
시간복잡도:O(N)
공간복잡도:O(N) -> O(1)
풀이:나는 아래와 같이 풀었는데 더 개선하면 투포인터로도 풀수있다! 생각해보니 그렇다 배열을 선언할필요없어지고 조금더 단순한 풀이가된다.
풀이는 아래첨부
*/
//내풀이
class Solution {
    public int trap(int[] h) {
        int len = h.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = h[0];
        right[len - 1] = h[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], h[i]);
            right[len - i - 1] = Math.max(right[len - i], h[len - i - 1]);
        }
        int answer = 0;
        for (int i = 1; i < len - 1; i++) {
            answer += Math.max(Math.min(left[i - 1], right[i + 1]) - h[i], 0);
        }
        return answer;
    }
}
//개선된 풀이
class Solution {
    public int trap(int[] h) {
        int left = 0, right = h.length - 1;
        int leftMax = 0, rightMax = 0;
        int trapped = 0;

        while (left < right) {
            if (h[left] < h[right]) {
                leftMax = Math.max(leftMax, h[left]);
                trapped += leftMax - h[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, h[right]);
                trapped += rightMax - h[right];
                right--;
            }
        }

        return trapped;
    }
}
