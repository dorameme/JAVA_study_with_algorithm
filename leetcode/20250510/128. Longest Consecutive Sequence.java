/*
start: 22:49
end: 23:22
시간복잡도:O(N)
공간복잡도:O(N)
풀이: O(N)에 풀기위해 set을 사용하여 일단 다 담아두고 
시작점에서 끝부분까지 길이를 구해 업데이트하며 풀었다.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        int ans = 0;
        for (int num : nums)
            s.add(num);
        for (Integer num : s) {

            if (!s.contains(num - 1)) {
                int maxLen = 1;
                for (int i = num + 1;; i++) {
                    if (s.contains(i))
                        maxLen++;
                    else break;
                }
                ans = Math.max(maxLen, ans);
            }
        }
        return ans;
    }
}
