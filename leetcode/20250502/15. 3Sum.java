/*
start:17:00
end:16:27
시간복잡도:O(N^2)
공간복잡도:O(N)
풀이: 너무 더럽게 풀어서... 개선된 코드를 첨부한다.
*/
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Step 1: 정렬
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 i는 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // 정답 조합 발견
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복 제거
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        HashSet<String> s = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] < -nums[i]) {
                    l++;
                    continue;
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                    continue;
                }
                else if(nums[i] + nums[l] + nums[r] == 0
                        && !s.contains(nums[i] + " " + " " + nums[l] + " " + nums[r])) {
                    s.add(nums[i] + " " + " " + nums[l] + " " + nums[r]);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    answer.add(tmp);
                    continue;
                }
                l++;
            }
        }
        return answer;
    }
}
